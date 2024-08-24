package com.cl.dao;

import com.cl.entity.LiuyanfankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LiuyanfankuiView;


/**
 * 留言反馈
 * 
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
public interface LiuyanfankuiDao extends BaseMapper<LiuyanfankuiEntity> {
	
	List<LiuyanfankuiView> selectListView(@Param("ew") Wrapper<LiuyanfankuiEntity> wrapper);

	List<LiuyanfankuiView> selectListView(Pagination page,@Param("ew") Wrapper<LiuyanfankuiEntity> wrapper);
	
	LiuyanfankuiView selectView(@Param("ew") Wrapper<LiuyanfankuiEntity> wrapper);
	

}
