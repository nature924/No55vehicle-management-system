
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
 * 事故登记
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shigudengji")
public class ShigudengjiController {
    private static final Logger logger = LoggerFactory.getLogger(ShigudengjiController.class);

    @Autowired
    private ShigudengjiService shigudengjiService;


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
        PageUtils page = shigudengjiService.queryPage(params);

        //字典表数据转换
        List<ShigudengjiView> list =(List<ShigudengjiView>)page.getList();
        for(ShigudengjiView c:list){
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
        ShigudengjiEntity shigudengji = shigudengjiService.selectById(id);
        if(shigudengji !=null){
            //entity转view
            ShigudengjiView view = new ShigudengjiView();
            BeanUtils.copyProperties( shigudengji , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shigudengji.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(shigudengji.getYuangongId());
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
    public R save(@RequestBody ShigudengjiEntity shigudengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shigudengji:{}",this.getClass().getName(),shigudengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            shigudengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShigudengjiEntity> queryWrapper = new EntityWrapper<ShigudengjiEntity>()
            .eq("yonghu_id", shigudengji.getYonghuId())
            .eq("yuangong_id", shigudengji.getYuangongId())
            .eq("shigudengji_uuid_number", shigudengji.getShigudengjiUuidNumber())
            .eq("shigudengji_name", shigudengji.getShigudengjiName())
            .eq("shigudengji_types", shigudengji.getShigudengjiTypes())
            .eq("zeren_types", shigudengji.getZerenTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShigudengjiEntity shigudengjiEntity = shigudengjiService.selectOne(queryWrapper);
        if(shigudengjiEntity==null){
            shigudengji.setInsertTime(new Date());
            shigudengji.setCreateTime(new Date());
            shigudengjiService.insert(shigudengji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShigudengjiEntity shigudengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shigudengji:{}",this.getClass().getName(),shigudengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("员工".equals(role))
//            shigudengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShigudengjiEntity> queryWrapper = new EntityWrapper<ShigudengjiEntity>()
            .notIn("id",shigudengji.getId())
            .andNew()
            .eq("yonghu_id", shigudengji.getYonghuId())
            .eq("yuangong_id", shigudengji.getYuangongId())
            .eq("shigudengji_uuid_number", shigudengji.getShigudengjiUuidNumber())
            .eq("shigudengji_name", shigudengji.getShigudengjiName())
            .eq("shigudengji_types", shigudengji.getShigudengjiTypes())
            .eq("zeren_types", shigudengji.getZerenTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShigudengjiEntity shigudengjiEntity = shigudengjiService.selectOne(queryWrapper);
        if(shigudengjiEntity==null){
            shigudengjiService.updateById(shigudengji);//根据id更新
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
        shigudengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShigudengjiEntity> shigudengjiList = new ArrayList<>();//上传的东西
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
                            ShigudengjiEntity shigudengjiEntity = new ShigudengjiEntity();
//                            shigudengjiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shigudengjiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            shigudengjiEntity.setShigudengjiUuidNumber(data.get(0));                    //事故登记唯一编号 要改的
//                            shigudengjiEntity.setShigudengjiName(data.get(0));                    //事故名称 要改的
//                            shigudengjiEntity.setShigudengjiTypes(Integer.valueOf(data.get(0)));   //事故类型 要改的
//                            shigudengjiEntity.setZerenTypes(Integer.valueOf(data.get(0)));   //责任方 要改的
//                            shigudengjiEntity.setShigudengjiContent("");//照片
//                            shigudengjiEntity.setShigudengjiTime(new Date(data.get(0)));          //发生时间 要改的
//                            shigudengjiEntity.setInsertTime(date);//时间
//                            shigudengjiEntity.setCreateTime(date);//时间
                            shigudengjiList.add(shigudengjiEntity);


                            //把要查询是否重复的字段放入map中
                                //事故登记唯一编号
                                if(seachFields.containsKey("shigudengjiUuidNumber")){
                                    List<String> shigudengjiUuidNumber = seachFields.get("shigudengjiUuidNumber");
                                    shigudengjiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shigudengjiUuidNumber = new ArrayList<>();
                                    shigudengjiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shigudengjiUuidNumber",shigudengjiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //事故登记唯一编号
                        List<ShigudengjiEntity> shigudengjiEntities_shigudengjiUuidNumber = shigudengjiService.selectList(new EntityWrapper<ShigudengjiEntity>().in("shigudengji_uuid_number", seachFields.get("shigudengjiUuidNumber")));
                        if(shigudengjiEntities_shigudengjiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShigudengjiEntity s:shigudengjiEntities_shigudengjiUuidNumber){
                                repeatFields.add(s.getShigudengjiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [事故登记唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shigudengjiService.insertBatch(shigudengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
