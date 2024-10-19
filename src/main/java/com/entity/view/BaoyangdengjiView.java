package com.entity.view;

import com.entity.BaoyangdengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 保养登记
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("baoyangdengji")
public class BaoyangdengjiView extends BaoyangdengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 保养类型的值
		*/
		private String baoyangdengjiValue;



		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 准驾车型
			*/
			private Integer zhunjiaTypes;
				/**
				* 准驾车型的值
				*/
				private String zhunjiaValue;
			/**
			* 驾驶证
			*/
			private String jiashizhenghao;
			/**
			* 用户备注
			*/
			private String yonghuContent;

		//级联表 yuangong
			/**
			* 工号
			*/
			private String yuangongUuidNumber;
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工头像
			*/
			private String yuangongPhoto;
			/**
			* 电子邮箱
			*/
			private String yuangongEmail;

	public BaoyangdengjiView() {

	}

	public BaoyangdengjiView(BaoyangdengjiEntity baoyangdengjiEntity) {
		try {
			BeanUtils.copyProperties(this, baoyangdengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 保养类型的值
			*/
			public String getBaoyangdengjiValue() {
				return baoyangdengjiValue;
			}
			/**
			* 设置： 保养类型的值
			*/
			public void setBaoyangdengjiValue(String baoyangdengjiValue) {
				this.baoyangdengjiValue = baoyangdengjiValue;
			}






















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
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
					* 获取： 准驾车型
					*/
					public Integer getZhunjiaTypes() {
						return zhunjiaTypes;
					}
					/**
					* 设置： 准驾车型
					*/
					public void setZhunjiaTypes(Integer zhunjiaTypes) {
						this.zhunjiaTypes = zhunjiaTypes;
					}


						/**
						* 获取： 准驾车型的值
						*/
						public String getZhunjiaValue() {
							return zhunjiaValue;
						}
						/**
						* 设置： 准驾车型的值
						*/
						public void setZhunjiaValue(String zhunjiaValue) {
							this.zhunjiaValue = zhunjiaValue;
						}
					/**
					* 获取： 驾驶证
					*/
					public String getJiashizhenghao() {
						return jiashizhenghao;
					}
					/**
					* 设置： 驾驶证
					*/
					public void setJiashizhenghao(String jiashizhenghao) {
						this.jiashizhenghao = jiashizhenghao;
					}
					/**
					* 获取： 用户备注
					*/
					public String getYonghuContent() {
						return yonghuContent;
					}
					/**
					* 设置： 用户备注
					*/
					public void setYonghuContent(String yonghuContent) {
						this.yonghuContent = yonghuContent;
					}




				//级联表的get和set yuangong
					/**
					* 获取： 工号
					*/
					public String getYuangongUuidNumber() {
						return yuangongUuidNumber;
					}
					/**
					* 设置： 工号
					*/
					public void setYuangongUuidNumber(String yuangongUuidNumber) {
						this.yuangongUuidNumber = yuangongUuidNumber;
					}
					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}
					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}
					/**
					* 获取： 员工头像
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工头像
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYuangongEmail() {
						return yuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYuangongEmail(String yuangongEmail) {
						this.yuangongEmail = yuangongEmail;
					}



}
