package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.HuodongcanjiaEntity;
import com.cl.entity.view.HuodongcanjiaView;

import com.cl.service.HuodongcanjiaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 活动参加
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
@RestController
@RequestMapping("/huodongcanjia")
public class HuodongcanjiaController {
    @Autowired
    private HuodongcanjiaService huodongcanjiaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongcanjiaEntity huodongcanjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			huodongcanjia.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			huodongcanjia.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuodongcanjiaEntity> ew = new EntityWrapper<HuodongcanjiaEntity>();

		PageUtils page = huodongcanjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongcanjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongcanjiaEntity huodongcanjia, 
		HttpServletRequest request){
        EntityWrapper<HuodongcanjiaEntity> ew = new EntityWrapper<HuodongcanjiaEntity>();

		PageUtils page = huodongcanjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongcanjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongcanjiaEntity huodongcanjia){
       	EntityWrapper<HuodongcanjiaEntity> ew = new EntityWrapper<HuodongcanjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongcanjia, "huodongcanjia")); 
        return R.ok().put("data", huodongcanjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongcanjiaEntity huodongcanjia){
        EntityWrapper< HuodongcanjiaEntity> ew = new EntityWrapper< HuodongcanjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongcanjia, "huodongcanjia")); 
		HuodongcanjiaView huodongcanjiaView =  huodongcanjiaService.selectView(ew);
		return R.ok("查询活动参加成功").put("data", huodongcanjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongcanjiaEntity huodongcanjia = huodongcanjiaService.selectById(id);
		huodongcanjia = huodongcanjiaService.selectView(new EntityWrapper<HuodongcanjiaEntity>().eq("id", id));
        return R.ok().put("data", huodongcanjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongcanjiaEntity huodongcanjia = huodongcanjiaService.selectById(id);
		huodongcanjia = huodongcanjiaService.selectView(new EntityWrapper<HuodongcanjiaEntity>().eq("id", id));
        return R.ok().put("data", huodongcanjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongcanjiaEntity huodongcanjia, HttpServletRequest request){
    	huodongcanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongcanjia);
        huodongcanjiaService.insert(huodongcanjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongcanjiaEntity huodongcanjia, HttpServletRequest request){
    	huodongcanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongcanjia);
        huodongcanjiaService.insert(huodongcanjia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongcanjiaEntity huodongcanjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongcanjia);
        huodongcanjiaService.updateById(huodongcanjia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongcanjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
