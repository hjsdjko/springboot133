package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuodongcanjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongcanjiaView;


/**
 * 活动参加
 *
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
public interface HuodongcanjiaService extends IService<HuodongcanjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongcanjiaView> selectListView(Wrapper<HuodongcanjiaEntity> wrapper);
   	
   	HuodongcanjiaView selectView(@Param("ew") Wrapper<HuodongcanjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongcanjiaEntity> wrapper);
   	

}

