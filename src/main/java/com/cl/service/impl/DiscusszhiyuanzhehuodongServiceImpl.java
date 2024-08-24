package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscusszhiyuanzhehuodongDao;
import com.cl.entity.DiscusszhiyuanzhehuodongEntity;
import com.cl.service.DiscusszhiyuanzhehuodongService;
import com.cl.entity.view.DiscusszhiyuanzhehuodongView;

@Service("discusszhiyuanzhehuodongService")
public class DiscusszhiyuanzhehuodongServiceImpl extends ServiceImpl<DiscusszhiyuanzhehuodongDao, DiscusszhiyuanzhehuodongEntity> implements DiscusszhiyuanzhehuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhiyuanzhehuodongEntity> page = this.selectPage(
                new Query<DiscusszhiyuanzhehuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusszhiyuanzhehuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
		  Page<DiscusszhiyuanzhehuodongView> page =new Query<DiscusszhiyuanzhehuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusszhiyuanzhehuodongView> selectListView(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhiyuanzhehuodongView selectView(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
