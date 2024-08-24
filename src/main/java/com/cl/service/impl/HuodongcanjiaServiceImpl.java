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


import com.cl.dao.HuodongcanjiaDao;
import com.cl.entity.HuodongcanjiaEntity;
import com.cl.service.HuodongcanjiaService;
import com.cl.entity.view.HuodongcanjiaView;

@Service("huodongcanjiaService")
public class HuodongcanjiaServiceImpl extends ServiceImpl<HuodongcanjiaDao, HuodongcanjiaEntity> implements HuodongcanjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongcanjiaEntity> page = this.selectPage(
                new Query<HuodongcanjiaEntity>(params).getPage(),
                new EntityWrapper<HuodongcanjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongcanjiaEntity> wrapper) {
		  Page<HuodongcanjiaView> page =new Query<HuodongcanjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuodongcanjiaView> selectListView(Wrapper<HuodongcanjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongcanjiaView selectView(Wrapper<HuodongcanjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
