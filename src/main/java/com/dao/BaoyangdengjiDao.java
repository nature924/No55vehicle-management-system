package com.dao;

import com.entity.BaoyangdengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoyangdengjiView;

/**
 * 保养登记 Dao 接口
 *
 * @author 
 */
public interface BaoyangdengjiDao extends BaseMapper<BaoyangdengjiEntity> {

   List<BaoyangdengjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
