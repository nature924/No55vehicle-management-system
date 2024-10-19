package com.entity.view;

import com.entity.CheliangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cheliang")
public class CheliangView extends CheliangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 车辆类型的值
		*/
		private String cheliangValue;



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

	public CheliangView() {

	}

	public CheliangView(CheliangEntity cheliangEntity) {
		try {
			BeanUtils.copyProperties(this, cheliangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 车辆类型的值
			*/
			public String getCheliangValue() {
				return cheliangValue;
			}
			/**
			* 设置： 车辆类型的值
			*/
			public void setCheliangValue(String cheliangValue) {
				this.cheliangValue = cheliangValue;
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




}
