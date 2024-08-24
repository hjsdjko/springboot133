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

import com.cl.entity.LiuyanfankuiEntity;
import com.cl.entity.view.LiuyanfankuiView;

import com.cl.service.LiuyanfankuiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 留言反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-25 22:31:06
 */
@RestController
@RequestMapping("/liuyanfankui")
public class LiuyanfankuiController {
    @Autowired
    private LiuyanfankuiService liuyanfankuiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LiuyanfankuiEntity liuyanfankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			liuyanfankui.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LiuyanfankuiEntity> ew = new EntityWrapper<LiuyanfankuiEntity>();

		PageUtils page = liuyanfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanfankui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LiuyanfankuiEntity liuyanfankui, 
		HttpServletRequest request){
        EntityWrapper<LiuyanfankuiEntity> ew = new EntityWrapper<LiuyanfankuiEntity>();

		PageUtils page = liuyanfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanfankui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LiuyanfankuiEntity liuyanfankui){
       	EntityWrapper<LiuyanfankuiEntity> ew = new EntityWrapper<LiuyanfankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( liuyanfankui, "liuyanfankui")); 
        return R.ok().put("data", liuyanfankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LiuyanfankuiEntity liuyanfankui){
        EntityWrapper< LiuyanfankuiEntity> ew = new EntityWrapper< LiuyanfankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( liuyanfankui, "liuyanfankui")); 
		LiuyanfankuiView liuyanfankuiView =  liuyanfankuiService.selectView(ew);
		return R.ok("查询留言反馈成功").put("data", liuyanfankuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LiuyanfankuiEntity liuyanfankui = liuyanfankuiService.selectById(id);
		liuyanfankui = liuyanfankuiService.selectView(new EntityWrapper<LiuyanfankuiEntity>().eq("id", id));
        return R.ok().put("data", liuyanfankui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LiuyanfankuiEntity liuyanfankui = liuyanfankuiService.selectById(id);
		liuyanfankui = liuyanfankuiService.selectView(new EntityWrapper<LiuyanfankuiEntity>().eq("id", id));
        return R.ok().put("data", liuyanfankui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LiuyanfankuiEntity liuyanfankui, HttpServletRequest request){
    	liuyanfankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuyanfankui);
        liuyanfankuiService.insert(liuyanfankui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LiuyanfankuiEntity liuyanfankui, HttpServletRequest request){
    	liuyanfankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuyanfankui);
        liuyanfankuiService.insert(liuyanfankui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LiuyanfankuiEntity liuyanfankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(liuyanfankui);
        liuyanfankuiService.updateById(liuyanfankui);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LiuyanfankuiEntity> list = new ArrayList<LiuyanfankuiEntity>();
        for(Long id : ids) {
            LiuyanfankuiEntity liuyanfankui = liuyanfankuiService.selectById(id);
            liuyanfankui.setSfsh(sfsh);
            liuyanfankui.setShhf(shhf);
            list.add(liuyanfankui);
        }
        liuyanfankuiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        liuyanfankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
