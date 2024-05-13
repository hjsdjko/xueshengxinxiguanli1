package com.entity.view;

import com.entity.BanjiKechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级_课程
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-13
 */
@TableName("banji_kecheng")
public class BanjiKechengView extends BanjiKechengEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 banji
			/**
			* 专业
			*/
			private Integer zhuanyeTypes;
				/**
				* 专业的值
				*/
				private String zhuanyeValue;
			/**
			* 班级名称
			*/
			private String banjiName;

		//级联表 kecheng
			/**
			* 老师
			*/
			private Integer laoshiId;
			/**
			* 课程名称
			*/
			private String kechengName;
			/**
			* 课程内容
			*/
			private String kechengContent;


			// 老师姓名
			private String name;
			// 老师手机号
			private String phone;
			//老师身份证号
			private String idNumber;


	public BanjiKechengView() {

	}

	public BanjiKechengView(BanjiKechengEntity banjiKechengEntity) {
		try {
			BeanUtils.copyProperties(this, banjiKechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set banji
					/**
					* 获取： 专业
					*/
					public Integer getZhuanyeTypes() {
						return zhuanyeTypes;
					}
					/**
					* 设置： 专业
					*/
					public void setZhuanyeTypes(Integer zhuanyeTypes) {
						this.zhuanyeTypes = zhuanyeTypes;
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
					/**
					* 获取： 班级名称
					*/
					public String getBanjiName() {
						return banjiName;
					}
					/**
					* 设置： 班级名称
					*/
					public void setBanjiName(String banjiName) {
						this.banjiName = banjiName;
					}













				//级联表的get和set kecheng
					/**
					* 获取： 老师
					*/
					public Integer getLaoshiId() {
						return laoshiId;
					}
					/**
					* 设置： 老师
					*/
					public void setLaoshiId(Integer laoshiId) {
						this.laoshiId = laoshiId;
					}
					/**
					* 获取： 课程名称
					*/
					public String getKechengName() {
						return kechengName;
					}
					/**
					* 设置： 课程名称
					*/
					public void setKechengName(String kechengName) {
						this.kechengName = kechengName;
					}
					/**
					* 获取： 课程内容
					*/
					public String getKechengContent() {
						return kechengContent;
					}
					/**
					* 设置： 课程内容
					*/
					public void setKechengContent(String kechengContent) {
						this.kechengContent = kechengContent;
					}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
}
