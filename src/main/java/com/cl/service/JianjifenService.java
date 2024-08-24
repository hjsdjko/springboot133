package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianjifenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianjifenView;


/**
 * 减积分
 *
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
public interface JianjifenService extends IService<JianjifenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianjifenView> selectListView(Wrapper<JianjifenEntity> wrapper);
   	
   	JianjifenView selectView(@Param("ew") Wrapper<JianjifenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianjifenEntity> wrapper);
   	

}

