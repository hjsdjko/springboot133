package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiajifenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajifenView;


/**
 * 加积分
 *
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
public interface JiajifenService extends IService<JiajifenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiajifenView> selectListView(Wrapper<JiajifenEntity> wrapper);
   	
   	JiajifenView selectView(@Param("ew") Wrapper<JiajifenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiajifenEntity> wrapper);
   	

}

