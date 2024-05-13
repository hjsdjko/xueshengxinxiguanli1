package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.LaoshiEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.BanjiKechengEntity;

import com.entity.view.BanjiKechengView;
import com.entity.BanjiEntity;
import com.entity.KechengEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 班级_课程
 * 后端接口
 * @author
 * @email
 * @date 2021-03-13
*/
@RestController
@Controller
@RequestMapping("/banjiKecheng")
public class BanjiKechengController {
    private static final Logger logger = LoggerFactory.getLogger(BanjiKechengController.class);

    @Autowired
    private BanjiKechengService banjiKechengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private BanjiService banjiService;
    @Autowired
    private KechengService kechengService;
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
        PageUtils page = banjiKechengService.queryPage(params);

        //字典表数据转换
        List<BanjiKechengView> list =(List<BanjiKechengView>)page.getList();
        for(BanjiKechengView c:list){
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
        BanjiKechengEntity banjiKecheng = banjiKechengService.selectById(id);
        if(banjiKecheng !=null){
            //entity转view
            BanjiKechengView view = new BanjiKechengView();
            BeanUtils.copyProperties( banjiKecheng , view );//把实体数据重构到view中

            //级联表
            BanjiEntity banji = banjiService.selectById(banjiKecheng.getBanjiId());
            if(banji != null){
                BeanUtils.copyProperties( banji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBanjiId(banji.getId());
            }
            //级联表
            KechengEntity kecheng = kechengService.selectById(banjiKecheng.getKechengId());
            if(kecheng != null){
                BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKechengId(kecheng.getId());
                if(kecheng.getLaoshiId() != null){
                    LaoshiEntity laoshiEntity = laoshiService.selectById(kecheng.getLaoshiId());
                    if(laoshiEntity != null){
                        view.setName(laoshiEntity.getName());
                        view.setPhone(laoshiEntity.getPhone());
                        view.setIdNumber(laoshiEntity.getIdNumber());
                    }
                }

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
    public R save(@RequestBody BanjiKechengEntity banjiKecheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,banjiKecheng:{}",this.getClass().getName(),banjiKecheng.toString());
        Wrapper<BanjiKechengEntity> queryWrapper = new EntityWrapper<BanjiKechengEntity>()
            .eq("banji_id", banjiKecheng.getBanjiId())
            .eq("kecheng_id", banjiKecheng.getKechengId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BanjiKechengEntity banjiKechengEntity = banjiKechengService.selectOne(queryWrapper);
        if(banjiKechengEntity==null){
            banjiKecheng.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      banjiKecheng.set
        //  }
            banjiKechengService.insert(banjiKecheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BanjiKechengEntity banjiKecheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,banjiKecheng:{}",this.getClass().getName(),banjiKecheng.toString());
        //根据字段查询是否有相同数据
        Wrapper<BanjiKechengEntity> queryWrapper = new EntityWrapper<BanjiKechengEntity>()
            .notIn("id",banjiKecheng.getId())
            .eq("banji_id", banjiKecheng.getBanjiId())
            .eq("kecheng_id", banjiKecheng.getKechengId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BanjiKechengEntity banjiKechengEntity = banjiKechengService.selectOne(queryWrapper);
        if(banjiKechengEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      banjiKecheng.set
            //  }
            banjiKechengService.updateById(banjiKecheng);//根据id更新
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
        banjiKechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

