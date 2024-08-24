package com.cl.entity.view;

import com.cl.entity.JianjifenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 减积分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
@TableName("jianjifen")
public class JianjifenView  extends JianjifenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianjifenView(){
	}
 
 	public JianjifenView(JianjifenEntity jianjifenEntity){
 	try {
			BeanUtils.copyProperties(this, jianjifenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
