package com.entity.view;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-13
 */
@TableName("chengji")
public class ChengjiView extends ChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



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

		//级联表 yonghu
			/**
			* 账户
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 姓名
			*/
			private String name;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 身份证号
			*/
			private String idNumber;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 照片
			*/
			private String myPhoto;
			/**
			* 民族
			*/
			private String nation;
			/**
			* 政治面貌
			*/
			private Integer politicsTypes;
				/**
				* 政治面貌的值
				*/
				private String politicsValue;
			/**
			* 籍贯
			*/
			private String birthplace;
			/**
			* 是否领取过物品
			*/
			private Integer wupinTypes;
				/**
				* 是否领取过物品的值
				*/
				private String wupinValue;
			/**
			* 班级
			*/
			private Integer banjiId;
			/**
			* 用户状态
			*/
			private Integer yonghuTypes;
				/**
				* 用户状态的值
				*/
				private String yonghuValue;

	public ChengjiView() {

	}

	public ChengjiView(ChengjiEntity chengjiEntity) {
		try {
			BeanUtils.copyProperties(this, chengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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





				//级联表的get和set yonghu
					/**
					* 获取： 账户
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账户
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 姓名
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 姓名
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 身份证号
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 照片
					*/
					public String getMyPhoto() {
						return myPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setMyPhoto(String myPhoto) {
						this.myPhoto = myPhoto;
					}
					/**
					* 获取： 民族
					*/
					public String getNation() {
						return nation;
					}
					/**
					* 设置： 民族
					*/
					public void setNation(String nation) {
						this.nation = nation;
					}
					/**
					* 获取： 政治面貌
					*/
					public Integer getPoliticsTypes() {
						return politicsTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setPoliticsTypes(Integer politicsTypes) {
						this.politicsTypes = politicsTypes;
					}


						/**
						* 获取： 政治面貌的值
						*/
						public String getPoliticsValue() {
							return politicsValue;
						}
						/**
						* 设置： 政治面貌的值
						*/
						public void setPoliticsValue(String politicsValue) {
							this.politicsValue = politicsValue;
						}
					/**
					* 获取： 籍贯
					*/
					public String getBirthplace() {
						return birthplace;
					}
					/**
					* 设置： 籍贯
					*/
					public void setBirthplace(String birthplace) {
						this.birthplace = birthplace;
					}
					/**
					* 获取： 是否领取过物品
					*/
					public Integer getWupinTypes() {
						return wupinTypes;
					}
					/**
					* 设置： 是否领取过物品
					*/
					public void setWupinTypes(Integer wupinTypes) {
						this.wupinTypes = wupinTypes;
					}


						/**
						* 获取： 是否领取过物品的值
						*/
						public String getWupinValue() {
							return wupinValue;
						}
						/**
						* 设置： 是否领取过物品的值
						*/
						public void setWupinValue(String wupinValue) {
							this.wupinValue = wupinValue;
						}
					/**
					* 获取： 班级
					*/
					public Integer getBanjiId() {
						return banjiId;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiId(Integer banjiId) {
						this.banjiId = banjiId;
					}
					/**
					* 获取： 用户状态
					*/
					public Integer getYonghuTypes() {
						return yonghuTypes;
					}
					/**
					* 设置： 用户状态
					*/
					public void setYonghuTypes(Integer yonghuTypes) {
						this.yonghuTypes = yonghuTypes;
					}


						/**
						* 获取： 用户状态的值
						*/
						public String getYonghuValue() {
							return yonghuValue;
						}
						/**
						* 设置： 用户状态的值
						*/
						public void setYonghuValue(String yonghuValue) {
							this.yonghuValue = yonghuValue;
						}




}
