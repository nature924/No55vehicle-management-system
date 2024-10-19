package com.dao;

import com.entity.WeixiudengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiudengjiView;

/**
 * 维修登记 Dao 接口
 *
 * @author 
 */
public interface WeixiudengjiDao extends BaseMapper<WeixiudengjiEntity> {

   List<WeixiudengjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
