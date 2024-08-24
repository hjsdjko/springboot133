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

import com.cl.entity.JiajifenEntity;
import com.cl.entity.view.JiajifenView;

import com.cl.service.JiajifenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 加积分
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
@RestController
@RequestMapping("/jiajifen")
public class JiajifenController {
    @Autowired
    private JiajifenService jiajifenService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiajifenEntity jiajifen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			jiajifen.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiajifenEntity> ew = new EntityWrapper<JiajifenEntity>();

		PageUtils page = jiajifenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajifen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiajifenEntity jiajifen, 
		HttpServletRequest request){
        EntityWrapper<JiajifenEntity> ew = new EntityWrapper<JiajifenEntity>();

		PageUtils page = jiajifenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajifen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiajifenEntity jiajifen){
       	EntityWrapper<JiajifenEntity> ew = new EntityWrapper<JiajifenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiajifen, "jiajifen")); 
        return R.ok().put("data", jiajifenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiajifenEntity jiajifen){
        EntityWrapper< JiajifenEntity> ew = new EntityWrapper< JiajifenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiajifen, "jiajifen")); 
		JiajifenView jiajifenView =  jiajifenService.selectView(ew);
		return R.ok("查询加积分成功").put("data", jiajifenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiajifenEntity jiajifen = jiajifenService.selectById(id);
		jiajifen = jiajifenService.selectView(new EntityWrapper<JiajifenEntity>().eq("id", id));
        return R.ok().put("data", jiajifen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiajifenEntity jiajifen = jiajifenService.selectById(id);
		jiajifen = jiajifenService.selectView(new EntityWrapper<JiajifenEntity>().eq("id", id));
        return R.ok().put("data", jiajifen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiajifenEntity jiajifen, HttpServletRequest request){
    	jiajifen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajifen);
        jiajifenService.insert(jiajifen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiajifenEntity jiajifen, HttpServletRequest request){
    	jiajifen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajifen);
        jiajifenService.insert(jiajifen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiajifenEntity jiajifen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiajifen);
        jiajifenService.updateById(jiajifen);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JiajifenEntity> list = new ArrayList<JiajifenEntity>();
        for(Long id : ids) {
            JiajifenEntity jiajifen = jiajifenService.selectById(id);
            jiajifen.setSfsh(sfsh);
            jiajifen.setShhf(shhf);
            list.add(jiajifen);
        }
        jiajifenService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiajifenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
