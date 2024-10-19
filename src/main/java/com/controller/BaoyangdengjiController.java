
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 保养登记
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/baoyangdengji")
public class BaoyangdengjiController {
    private static final Logger logger = LoggerFactory.getLogger(BaoyangdengjiController.class);

    @Autowired
    private BaoyangdengjiService baoyangdengjiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = baoyangdengjiService.queryPage(params);

        //字典表数据转换
        List<BaoyangdengjiView> list =(List<BaoyangdengjiView>)page.getList();
        for(BaoyangdengjiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BaoyangdengjiEntity baoyangdengji = baoyangdengjiService.selectById(id);
        if(baoyangdengji !=null){
            //entity转view
            BaoyangdengjiView view = new BaoyangdengjiView();
            BeanUtils.copyProperties( baoyangdengji , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(baoyangdengji.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(baoyangdengji.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BaoyangdengjiEntity baoyangdengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoyangdengji:{}",this.getClass().getName(),baoyangdengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            baoyangdengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BaoyangdengjiEntity> queryWrapper = new EntityWrapper<BaoyangdengjiEntity>()
            .eq("yonghu_id", baoyangdengji.getYonghuId())
            .eq("yuangong_id", baoyangdengji.getYuangongId())
            .eq("baoyangdengji_uuid_number", baoyangdengji.getBaoyangdengjiUuidNumber())
            .eq("baoyangdengji_name", baoyangdengji.getBaoyangdengjiName())
            .eq("baoyangdengji_types", baoyangdengji.getBaoyangdengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoyangdengjiEntity baoyangdengjiEntity = baoyangdengjiService.selectOne(queryWrapper);
        if(baoyangdengjiEntity==null){
            baoyangdengji.setInsertTime(new Date());
            baoyangdengji.setCreateTime(new Date());
            baoyangdengjiService.insert(baoyangdengji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaoyangdengjiEntity baoyangdengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,baoyangdengji:{}",this.getClass().getName(),baoyangdengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("员工".equals(role))
//            baoyangdengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BaoyangdengjiEntity> queryWrapper = new EntityWrapper<BaoyangdengjiEntity>()
            .notIn("id",baoyangdengji.getId())
            .andNew()
            .eq("yonghu_id", baoyangdengji.getYonghuId())
            .eq("yuangong_id", baoyangdengji.getYuangongId())
            .eq("baoyangdengji_uuid_number", baoyangdengji.getBaoyangdengjiUuidNumber())
            .eq("baoyangdengji_name", baoyangdengji.getBaoyangdengjiName())
            .eq("baoyangdengji_types", baoyangdengji.getBaoyangdengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoyangdengjiEntity baoyangdengjiEntity = baoyangdengjiService.selectOne(queryWrapper);
        if(baoyangdengjiEntity==null){
            baoyangdengjiService.updateById(baoyangdengji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        baoyangdengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<BaoyangdengjiEntity> baoyangdengjiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BaoyangdengjiEntity baoyangdengjiEntity = new BaoyangdengjiEntity();
//                            baoyangdengjiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            baoyangdengjiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            baoyangdengjiEntity.setBaoyangdengjiUuidNumber(data.get(0));                    //保养登记唯一编号 要改的
//                            baoyangdengjiEntity.setBaoyangdengjiName(data.get(0));                    //保养名称 要改的
//                            baoyangdengjiEntity.setBaoyangdengjiTypes(Integer.valueOf(data.get(0)));   //保养类型 要改的
//                            baoyangdengjiEntity.setBaoyangdengjiContent("");//照片
//                            baoyangdengjiEntity.setBaoyangdengjiTime(new Date(data.get(0)));          //保养时间 要改的
//                            baoyangdengjiEntity.setInsertTime(date);//时间
//                            baoyangdengjiEntity.setCreateTime(date);//时间
                            baoyangdengjiList.add(baoyangdengjiEntity);


                            //把要查询是否重复的字段放入map中
                                //保养登记唯一编号
                                if(seachFields.containsKey("baoyangdengjiUuidNumber")){
                                    List<String> baoyangdengjiUuidNumber = seachFields.get("baoyangdengjiUuidNumber");
                                    baoyangdengjiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> baoyangdengjiUuidNumber = new ArrayList<>();
                                    baoyangdengjiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("baoyangdengjiUuidNumber",baoyangdengjiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //保养登记唯一编号
                        List<BaoyangdengjiEntity> baoyangdengjiEntities_baoyangdengjiUuidNumber = baoyangdengjiService.selectList(new EntityWrapper<BaoyangdengjiEntity>().in("baoyangdengji_uuid_number", seachFields.get("baoyangdengjiUuidNumber")));
                        if(baoyangdengjiEntities_baoyangdengjiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BaoyangdengjiEntity s:baoyangdengjiEntities_baoyangdengjiUuidNumber){
                                repeatFields.add(s.getBaoyangdengjiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [保养登记唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        baoyangdengjiService.insertBatch(baoyangdengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
