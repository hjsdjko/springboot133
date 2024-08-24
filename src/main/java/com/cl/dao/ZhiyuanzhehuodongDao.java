package com.cl.dao;

import com.cl.entity.ZhiyuanzhehuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanzhehuodongView;


/**
 * 志愿者活动
 * 
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
public interface ZhiyuanzhehuodongDao extends BaseMapper<ZhiyuanzhehuodongEntity> {
	
	List<ZhiyuanzhehuodongView> selectListView(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);

	List<ZhiyuanzhehuodongView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
	
	ZhiyuanzhehuodongView selectView(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
	

}
