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


import com.cl.dao.ZhiyuanzhehuodongDao;
import com.cl.entity.ZhiyuanzhehuodongEntity;
import com.cl.service.ZhiyuanzhehuodongService;
import com.cl.entity.view.ZhiyuanzhehuodongView;

@Service("zhiyuanzhehuodongService")
public class ZhiyuanzhehuodongServiceImpl extends ServiceImpl<ZhiyuanzhehuodongDao, ZhiyuanzhehuodongEntity> implements ZhiyuanzhehuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzhehuodongEntity> page = this.selectPage(
                new Query<ZhiyuanzhehuodongEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzhehuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
		  Page<ZhiyuanzhehuodongView> page =new Query<ZhiyuanzhehuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhiyuanzhehuodongView> selectListView(Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzhehuodongView selectView(Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
