package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LiuyanfankuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LiuyanfankuiView;


/**
 * 留言反馈
 *
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
public interface LiuyanfankuiService extends IService<LiuyanfankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiuyanfankuiView> selectListView(Wrapper<LiuyanfankuiEntity> wrapper);
   	
   	LiuyanfankuiView selectView(@Param("ew") Wrapper<LiuyanfankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiuyanfankuiEntity> wrapper);
   	

}

