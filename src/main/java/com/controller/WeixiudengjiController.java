
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
 * 维修登记
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weixiudengji")
public class WeixiudengjiController {
    private static final Logger logger = LoggerFactory.getLogger(WeixiudengjiController.class);

    @Autowired
    private WeixiudengjiService weixiudengjiService;


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
        PageUtils page = weixiudengjiService.queryPage(params);

        //字典表数据转换
        List<WeixiudengjiView> list =(List<WeixiudengjiView>)page.getList();
        for(WeixiudengjiView c:list){
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
        WeixiudengjiEntity weixiudengji = weixiudengjiService.selectById(id);
        if(weixiudengji !=null){
            //entity转view
            WeixiudengjiView view = new WeixiudengjiView();
            BeanUtils.copyProperties( weixiudengji , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(weixiudengji.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(weixiudengji.getYuangongId());
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
    public R save(@RequestBody WeixiudengjiEntity weixiudengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weixiudengji:{}",this.getClass().getName(),weixiudengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            weixiudengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WeixiudengjiEntity> queryWrapper = new EntityWrapper<WeixiudengjiEntity>()
            .eq("yonghu_id", weixiudengji.getYonghuId())
            .eq("yuangong_id", weixiudengji.getYuangongId())
            .eq("weixiudengji_uuid_number", weixiudengji.getWeixiudengjiUuidNumber())
            .eq("weixiudengji_name", weixiudengji.getWeixiudengjiName())
            .eq("weixiudengji_types", weixiudengji.getWeixiudengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiudengjiEntity weixiudengjiEntity = weixiudengjiService.selectOne(queryWrapper);
        if(weixiudengjiEntity==null){
            weixiudengji.setInsertTime(new Date());
            weixiudengji.setCreateTime(new Date());
            weixiudengjiService.insert(weixiudengji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiudengjiEntity weixiudengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,weixiudengji:{}",this.getClass().getName(),weixiudengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("员工".equals(role))
//            weixiudengji.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<WeixiudengjiEntity> queryWrapper = new EntityWrapper<WeixiudengjiEntity>()
            .notIn("id",weixiudengji.getId())
            .andNew()
            .eq("yonghu_id", weixiudengji.getYonghuId())
            .eq("yuangong_id", weixiudengji.getYuangongId())
            .eq("weixiudengji_uuid_number", weixiudengji.getWeixiudengjiUuidNumber())
            .eq("weixiudengji_name", weixiudengji.getWeixiudengjiName())
            .eq("weixiudengji_types", weixiudengji.getWeixiudengjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiudengjiEntity weixiudengjiEntity = weixiudengjiService.selectOne(queryWrapper);
        if(weixiudengjiEntity==null){
            weixiudengjiService.updateById(weixiudengji);//根据id更新
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
        weixiudengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<WeixiudengjiEntity> weixiudengjiList = new ArrayList<>();//上传的东西
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
                            WeixiudengjiEntity weixiudengjiEntity = new WeixiudengjiEntity();
//                            weixiudengjiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            weixiudengjiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            weixiudengjiEntity.setWeixiudengjiUuidNumber(data.get(0));                    //维修登记唯一编号 要改的
//                            weixiudengjiEntity.setWeixiudengjiName(data.get(0));                    //维修名称 要改的
//                            weixiudengjiEntity.setWeixiudengjiTypes(Integer.valueOf(data.get(0)));   //维修类型 要改的
//                            weixiudengjiEntity.setWeixiudengjiContent("");//照片
//                            weixiudengjiEntity.setWeixiudengjiTime(new Date(data.get(0)));          //维修时间 要改的
//                            weixiudengjiEntity.setInsertTime(date);//时间
//                            weixiudengjiEntity.setCreateTime(date);//时间
                            weixiudengjiList.add(weixiudengjiEntity);


                            //把要查询是否重复的字段放入map中
                                //维修登记唯一编号
                                if(seachFields.containsKey("weixiudengjiUuidNumber")){
                                    List<String> weixiudengjiUuidNumber = seachFields.get("weixiudengjiUuidNumber");
                                    weixiudengjiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiudengjiUuidNumber = new ArrayList<>();
                                    weixiudengjiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weixiudengjiUuidNumber",weixiudengjiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //维修登记唯一编号
                        List<WeixiudengjiEntity> weixiudengjiEntities_weixiudengjiUuidNumber = weixiudengjiService.selectList(new EntityWrapper<WeixiudengjiEntity>().in("weixiudengji_uuid_number", seachFields.get("weixiudengjiUuidNumber")));
                        if(weixiudengjiEntities_weixiudengjiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiudengjiEntity s:weixiudengjiEntities_weixiudengjiUuidNumber){
                                repeatFields.add(s.getWeixiudengjiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维修登记唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weixiudengjiService.insertBatch(weixiudengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
