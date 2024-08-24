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


import com.cl.dao.JiajifenDao;
import com.cl.entity.JiajifenEntity;
import com.cl.service.JiajifenService;
import com.cl.entity.view.JiajifenView;

@Service("jiajifenService")
public class JiajifenServiceImpl extends ServiceImpl<JiajifenDao, JiajifenEntity> implements JiajifenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiajifenEntity> page = this.selectPage(
                new Query<JiajifenEntity>(params).getPage(),
                new EntityWrapper<JiajifenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiajifenEntity> wrapper) {
		  Page<JiajifenView> page =new Query<JiajifenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiajifenView> selectListView(Wrapper<JiajifenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiajifenView selectView(Wrapper<JiajifenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
