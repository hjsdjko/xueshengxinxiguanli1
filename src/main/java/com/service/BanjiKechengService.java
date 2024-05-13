package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BanjiKechengEntity;
import java.util.Map;

/**
 * 班级_课程 服务类
 * @author 
 * @since 2021-03-13
 */
public interface BanjiKechengService extends IService<BanjiKechengEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}