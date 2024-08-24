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

import com.cl.entity.JianjifenEntity;
import com.cl.entity.view.JianjifenView;

import com.cl.service.JianjifenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 减积分
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
@RestController
@RequestMapping("/jianjifen")
public class JianjifenController {
    @Autowired
    private JianjifenService jianjifenService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianjifenEntity jianjifen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jianjifen.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianjifenEntity> ew = new EntityWrapper<JianjifenEntity>();

		PageUtils page = jianjifenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianjifen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianjifenEntity jianjifen, 
		HttpServletRequest request){
        EntityWrapper<JianjifenEntity> ew = new EntityWrapper<JianjifenEntity>();

		PageUtils page = jianjifenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianjifen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianjifenEntity jianjifen){
       	EntityWrapper<JianjifenEntity> ew = new EntityWrapper<JianjifenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianjifen, "jianjifen")); 
        return R.ok().put("data", jianjifenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianjifenEntity jianjifen){
        EntityWrapper< JianjifenEntity> ew = new EntityWrapper< JianjifenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianjifen, "jianjifen")); 
		JianjifenView jianjifenView =  jianjifenService.selectView(ew);
		return R.ok("查询减积分成功").put("data", jianjifenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianjifenEntity jianjifen = jianjifenService.selectById(id);
		jianjifen = jianjifenService.selectView(new EntityWrapper<JianjifenEntity>().eq("id", id));
        return R.ok().put("data", jianjifen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianjifenEntity jianjifen = jianjifenService.selectById(id);
		jianjifen = jianjifenService.selectView(new EntityWrapper<JianjifenEntity>().eq("id", id));
        return R.ok().put("data", jianjifen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianjifenEntity jianjifen, HttpServletRequest request){
    	jianjifen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianjifen);
        jianjifenService.insert(jianjifen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianjifenEntity jianjifen, HttpServletRequest request){
    	jianjifen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianjifen);
        jianjifenService.insert(jianjifen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianjifenEntity jianjifen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianjifen);
        jianjifenService.updateById(jianjifen);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JianjifenEntity> list = new ArrayList<JianjifenEntity>();
        for(Long id : ids) {
            JianjifenEntity jianjifen = jianjifenService.selectById(id);
            jianjifen.setSfsh(sfsh);
            jianjifen.setShhf(shhf);
            list.add(jianjifen);
        }
        jianjifenService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianjifenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
