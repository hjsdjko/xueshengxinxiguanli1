package com.entity.view;

import com.entity.JiangchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生奖惩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("jiangcheng")
public class JiangchengView extends JiangchengEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 奖惩类型的值
		*/
		private String jiangchengValue;



		//级联表 yonghu
			/**
			* 学生姓名
			*/
			private String name;
			/**
			* 学生性别
			*/
			private Integer sexTypes;
				/**
				* 学生性别的值
				*/
				private String sexValue;
			/**
			* 学生身份证号
			*/
			private String idNumber;
			/**
			* 学生手机号
			*/
			private String phone;
			/**
			* 学生照片
			*/
			private String myPhoto;

	public JiangchengView() {

	}

	public JiangchengView(JiangchengEntity jiangchengEntity) {
		try {
			BeanUtils.copyProperties(this, jiangchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 奖惩类型的值
			*/
			public String getJiangchengValue() {
				return jiangchengValue;
			}
			/**
			* 设置： 奖惩类型的值
			*/
			public void setJiangchengValue(String jiangchengValue) {
				this.jiangchengValue = jiangchengValue;
			}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSexTypes() {
		return sexTypes;
	}

	public void setSexTypes(Integer sexTypes) {
		this.sexTypes = sexTypes;
	}

	public String getSexValue() {
		return sexValue;
	}

	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMyPhoto() {
		return myPhoto;
	}

	public void setMyPhoto(String myPhoto) {
		this.myPhoto = myPhoto;
	}
}
