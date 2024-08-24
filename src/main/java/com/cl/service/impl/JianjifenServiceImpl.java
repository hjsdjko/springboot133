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


import com.cl.dao.JianjifenDao;
import com.cl.entity.JianjifenEntity;
import com.cl.service.JianjifenService;
import com.cl.entity.view.JianjifenView;

@Service("jianjifenService")
public class JianjifenServiceImpl extends ServiceImpl<JianjifenDao, JianjifenEntity> implements JianjifenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianjifenEntity> page = this.selectPage(
                new Query<JianjifenEntity>(params).getPage(),
                new EntityWrapper<JianjifenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianjifenEntity> wrapper) {
		  Page<JianjifenView> page =new Query<JianjifenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JianjifenView> selectListView(Wrapper<JianjifenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianjifenView selectView(Wrapper<JianjifenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
