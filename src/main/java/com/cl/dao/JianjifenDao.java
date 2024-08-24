package com.cl.dao;

import com.cl.entity.JianjifenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianjifenView;


/**
 * 减积分
 * 
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
public interface JianjifenDao extends BaseMapper<JianjifenEntity> {
	
	List<JianjifenView> selectListView(@Param("ew") Wrapper<JianjifenEntity> wrapper);

	List<JianjifenView> selectListView(Pagination page,@Param("ew") Wrapper<JianjifenEntity> wrapper);
	
	JianjifenView selectView(@Param("ew") Wrapper<JianjifenEntity> wrapper);
	

}
