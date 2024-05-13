package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.KechengEntity;

import com.service.KechengService;
import com.entity.view.KechengView;
import com.service.LaoshiService;
import com.entity.LaoshiEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 课程
 * 后端接口
 * @author
 * @email
 * @date 2021-03-13
*/
@RestController
@Controller
@RequestMapping("/kecheng")
public class KechengController {
    private static final Logger logger = LoggerFactory.getLogger(KechengController.class);

    @Autowired
    private KechengService kechengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private LaoshiService laoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = kechengService.queryPage(params);

        //字典表数据转换
        List<KechengView> list =(List<KechengView>)page.getList();
        for(KechengView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KechengEntity kecheng = kechengService.selectById(id);
        if(kecheng !=null){
            //entity转view
            KechengView view = new KechengView();
            BeanUtils.copyProperties( kecheng , view );//把实体数据重构到view中

            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(kecheng.getLaoshiId());
            if(laoshi != null){
                BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setLaoshiId(laoshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KechengEntity kecheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kecheng:{}",this.getClass().getName(),kecheng.toString());
        Wrapper<KechengEntity> queryWrapper = new EntityWrapper<KechengEntity>()
            .eq("laoshi_id", kecheng.getLaoshiId())
            .eq("kecheng_name", kecheng.getKechengName())
            .eq("kecheng_content", kecheng.getKechengContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechengEntity kechengEntity = kechengService.selectOne(queryWrapper);
        if(kechengEntity==null){
            kecheng.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      kecheng.set
        //  }
            kechengService.insert(kecheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KechengEntity kecheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kecheng:{}",this.getClass().getName(),kecheng.toString());
        //根据字段查询是否有相同数据
        Wrapper<KechengEntity> queryWrapper = new EntityWrapper<KechengEntity>()
            .notIn("id",kecheng.getId())
            .eq("laoshi_id", kecheng.getLaoshiId())
            .eq("kecheng_name", kecheng.getKechengName())
            .eq("kecheng_content", kecheng.getKechengContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechengEntity kechengEntity = kechengService.selectOne(queryWrapper);
        if(kechengEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kecheng.set
            //  }
            kechengService.updateById(kecheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

