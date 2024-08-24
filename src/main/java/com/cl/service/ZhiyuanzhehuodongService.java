package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhiyuanzhehuodongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanzhehuodongView;


/**
 * 志愿者活动
 *
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
public interface ZhiyuanzhehuodongService extends IService<ZhiyuanzhehuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzhehuodongView> selectListView(Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	
   	ZhiyuanzhehuodongView selectView(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	

}

