
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
 * 违章登记
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weizhangdengji")
public class WeizhangdengjiController {
    private static final Logger logger = LoggerFactory.getLogger(WeizhangdengjiController.class);

    @Autowired
    private WeizhangdengjiService weizhangdengjiService;


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
        PageUtils page = weizhangdengjiService.queryPage(params);

        //字典表数据转换
        List<WeizhangdengjiView> list =(List<WeizhangdengjiView>)page.getList();
        for(WeizhangdengjiView c:list){
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
        WeizhangdengjiEntity weizhangdengji = weizhangdengjiService.selectById(id);
        if(weizhangdengji !=null){
            //entity转view
            WeizhangdengjiView view = new WeizhangdengjiView();
            BeanUtils.copyProperties( weizhangdengji , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(weizhangdengji.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(weizhangdengji.getYuangongId());
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
    public R save(@RequestBody WeizhangdengjiEntity weizhangdengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weizhangdengji:{}",this.getClass().getName(),weizhangdengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            weizhangdengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WeizhangdengjiEntity> queryWrapper = new EntityWrapper<WeizhangdengjiEntity>()
            .eq("yonghu_id", weizhangdengji.getYonghuId())
            .eq("yuangong_id", weizhangdengji.getYuangongId())
            .eq("weizhangdengji_uuid_number", weizhangdengji.getWeizhangdengjiUuidNumber())
            .eq("weizhangdengji_name", weizhangdengji.getWeizhangdengjiName())
            .eq("weizhangdengji_types", weizhangdengji.getWeizhangdengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeizhangdengjiEntity weizhangdengjiEntity = weizhangdengjiService.selectOne(queryWrapper);
        if(weizhangdengjiEntity==null){
            weizhangdengji.setInsertTime(new Date());
            weizhangdengji.setCreateTime(new Date());
            weizhangdengjiService.insert(weizhangdengji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeizhangdengjiEntity weizhangdengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,weizhangdengji:{}",this.getClass().getName(),weizhangdengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("员工".equals(role))
//            weizhangdengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<WeizhangdengjiEntity> queryWrapper = new EntityWrapper<WeizhangdengjiEntity>()
            .notIn("id",weizhangdengji.getId())
            .andNew()
            .eq("yonghu_id", weizhangdengji.getYonghuId())
            .eq("yuangong_id", weizhangdengji.getYuangongId())
            .eq("weizhangdengji_uuid_number", weizhangdengji.getWeizhangdengjiUuidNumber())
            .eq("weizhangdengji_name", weizhangdengji.getWeizhangdengjiName())
            .eq("weizhangdengji_types", weizhangdengji.getWeizhangdengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeizhangdengjiEntity weizhangdengjiEntity = weizhangdengjiService.selectOne(queryWrapper);
        if(weizhangdengjiEntity==null){
            weizhangdengjiService.updateById(weizhangdengji);//根据id更新
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
        weizhangdengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<WeizhangdengjiEntity> weizhangdengjiList = new ArrayList<>();//上传的东西
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
                            WeizhangdengjiEntity weizhangdengjiEntity = new WeizhangdengjiEntity();
//                            weizhangdengjiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            weizhangdengjiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            weizhangdengjiEntity.setWeizhangdengjiUuidNumber(data.get(0));                    //违章登记唯一编号 要改的
//                            weizhangdengjiEntity.setWeizhangdengjiName(data.get(0));                    //违章名称 要改的
//                            weizhangdengjiEntity.setWeizhangdengjiTypes(Integer.valueOf(data.get(0)));   //违章类型 要改的
//                            weizhangdengjiEntity.setWeizhangdengjiContent("");//照片
//                            weizhangdengjiEntity.setChufaContent("");//照片
//                            weizhangdengjiEntity.setWeizhangdengjiTime(new Date(data.get(0)));          //违章时间 要改的
//                            weizhangdengjiEntity.setInsertTime(date);//时间
//                            weizhangdengjiEntity.setCreateTime(date);//时间
                            weizhangdengjiList.add(weizhangdengjiEntity);


                            //把要查询是否重复的字段放入map中
                                //违章登记唯一编号
                                if(seachFields.containsKey("weizhangdengjiUuidNumber")){
                                    List<String> weizhangdengjiUuidNumber = seachFields.get("weizhangdengjiUuidNumber");
                                    weizhangdengjiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weizhangdengjiUuidNumber = new ArrayList<>();
                                    weizhangdengjiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weizhangdengjiUuidNumber",weizhangdengjiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //违章登记唯一编号
                        List<WeizhangdengjiEntity> weizhangdengjiEntities_weizhangdengjiUuidNumber = weizhangdengjiService.selectList(new EntityWrapper<WeizhangdengjiEntity>().in("weizhangdengji_uuid_number", seachFields.get("weizhangdengjiUuidNumber")));
                        if(weizhangdengjiEntities_weizhangdengjiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeizhangdengjiEntity s:weizhangdengjiEntities_weizhangdengjiUuidNumber){
                                repeatFields.add(s.getWeizhangdengjiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [违章登记唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weizhangdengjiService.insertBatch(weizhangdengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
