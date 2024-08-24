package com.cl.entity.view;

import com.cl.entity.HuodongcanjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 活动参加
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
@TableName("huodongcanjia")
public class HuodongcanjiaView  extends HuodongcanjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongcanjiaView(){
	}
 
 	public HuodongcanjiaView(HuodongcanjiaEntity huodongcanjiaEntity){
 	try {
			BeanUtils.copyProperties(this, huodongcanjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
