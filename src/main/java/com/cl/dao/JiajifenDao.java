package com.cl.dao;

import com.cl.entity.JiajifenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajifenView;


/**
 * 加积分
 * 
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
public interface JiajifenDao extends BaseMapper<JiajifenEntity> {
	
	List<JiajifenView> selectListView(@Param("ew") Wrapper<JiajifenEntity> wrapper);

	List<JiajifenView> selectListView(Pagination page,@Param("ew") Wrapper<JiajifenEntity> wrapper);
	
	JiajifenView selectView(@Param("ew") Wrapper<JiajifenEntity> wrapper);
	

}
