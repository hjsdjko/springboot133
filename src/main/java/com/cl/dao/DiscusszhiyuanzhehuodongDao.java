package com.cl.dao;

import com.cl.entity.DiscusszhiyuanzhehuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusszhiyuanzhehuodongView;


/**
 * 志愿者活动评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
public interface DiscusszhiyuanzhehuodongDao extends BaseMapper<DiscusszhiyuanzhehuodongEntity> {
	
	List<DiscusszhiyuanzhehuodongView> selectListView(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);

	List<DiscusszhiyuanzhehuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
	
	DiscusszhiyuanzhehuodongView selectView(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
	

}
