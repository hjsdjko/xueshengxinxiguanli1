package com.entity.view;

import com.entity.BanjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-13
 */
@TableName("banji")
public class BanjiView extends BanjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 专业的值
		*/
		private String zhuanyeValue;



	public BanjiView() {

	}

	public BanjiView(BanjiEntity banjiEntity) {
		try {
			BeanUtils.copyProperties(this, banjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 专业的值
			*/
			public String getZhuanyeValue() {
				return zhuanyeValue;
			}
			/**
			* 设置： 专业的值
			*/
			public void setZhuanyeValue(String zhuanyeValue) {
				this.zhuanyeValue = zhuanyeValue;
			}










}
