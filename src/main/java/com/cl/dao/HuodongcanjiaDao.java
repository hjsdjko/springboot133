package com.cl.dao;

import com.cl.entity.HuodongcanjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongcanjiaView;


/**
 * 活动参加
 * 
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
public interface HuodongcanjiaDao extends BaseMapper<HuodongcanjiaEntity> {
	
	List<HuodongcanjiaView> selectListView(@Param("ew") Wrapper<HuodongcanjiaEntity> wrapper);

	List<HuodongcanjiaView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongcanjiaEntity> wrapper);
	
	HuodongcanjiaView selectView(@Param("ew") Wrapper<HuodongcanjiaEntity> wrapper);
	

}
