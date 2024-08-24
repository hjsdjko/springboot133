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

import com.cl.entity.ZhiyuanzhehuodongEntity;
import com.cl.entity.view.ZhiyuanzhehuodongView;

import com.cl.service.ZhiyuanzhehuodongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿者活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-25 22:31:05
 */
@RestController
@RequestMapping("/zhiyuanzhehuodong")
public class ZhiyuanzhehuodongController {
    @Autowired
    private ZhiyuanzhehuodongService zhiyuanzhehuodongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanzhehuodongEntity zhiyuanzhehuodong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			zhiyuanzhehuodong.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhiyuanzhehuodongEntity> ew = new EntityWrapper<ZhiyuanzhehuodongEntity>();

		PageUtils page = zhiyuanzhehuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhehuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanzhehuodongEntity zhiyuanzhehuodong, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanzhehuodongEntity> ew = new EntityWrapper<ZhiyuanzhehuodongEntity>();

		PageUtils page = zhiyuanzhehuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhehuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanzhehuodongEntity zhiyuanzhehuodong){
       	EntityWrapper<ZhiyuanzhehuodongEntity> ew = new EntityWrapper<ZhiyuanzhehuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanzhehuodong, "zhiyuanzhehuodong")); 
        return R.ok().put("data", zhiyuanzhehuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanzhehuodongEntity zhiyuanzhehuodong){
        EntityWrapper< ZhiyuanzhehuodongEntity> ew = new EntityWrapper< ZhiyuanzhehuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanzhehuodong, "zhiyuanzhehuodong")); 
		ZhiyuanzhehuodongView zhiyuanzhehuodongView =  zhiyuanzhehuodongService.selectView(ew);
		return R.ok("查询志愿者活动成功").put("data", zhiyuanzhehuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanzhehuodongEntity zhiyuanzhehuodong = zhiyuanzhehuodongService.selectById(id);
		zhiyuanzhehuodong = zhiyuanzhehuodongService.selectView(new EntityWrapper<ZhiyuanzhehuodongEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanzhehuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanzhehuodongEntity zhiyuanzhehuodong = zhiyuanzhehuodongService.selectById(id);
		zhiyuanzhehuodong = zhiyuanzhehuodongService.selectView(new EntityWrapper<ZhiyuanzhehuodongEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanzhehuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanzhehuodongEntity zhiyuanzhehuodong, HttpServletRequest request){
    	zhiyuanzhehuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzhehuodong);
        zhiyuanzhehuodongService.insert(zhiyuanzhehuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanzhehuodongEntity zhiyuanzhehuodong, HttpServletRequest request){
    	zhiyuanzhehuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzhehuodong);
        zhiyuanzhehuodongService.insert(zhiyuanzhehuodong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanzhehuodongEntity zhiyuanzhehuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanzhehuodong);
        zhiyuanzhehuodongService.updateById(zhiyuanzhehuodong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZhiyuanzhehuodongEntity> list = new ArrayList<ZhiyuanzhehuodongEntity>();
        for(Long id : ids) {
            ZhiyuanzhehuodongEntity zhiyuanzhehuodong = zhiyuanzhehuodongService.selectById(id);
            zhiyuanzhehuodong.setSfsh(sfsh);
            zhiyuanzhehuodong.setShhf(shhf);
            list.add(zhiyuanzhehuodong);
        }
        zhiyuanzhehuodongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanzhehuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
