package com.entity.view;

import com.entity.ShangpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shangpin")
public class ShangpinView extends ShangpinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 商品类型的值
		*/
		private String shangpinValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 shangjia
			/**
			* 商家名称
			*/
			private String shangjiaName;
			/**
			* 联系方式
			*/
			private String shangjiaPhone;
			/**
			* 邮箱
			*/
			private String shangjiaEmail;
			/**
			* 营业执照展示
			*/
			private String shangjiaPhoto;
			/**
			* 现有余额
			*/
			private Double newMoney;
			/**
			* 商家简介
			*/
			private String shangjiaContent;
			/**
			* 逻辑删除
			*/
			private Integer shangjiaDelete;

	public ShangpinView() {

	}

	public ShangpinView(ShangpinEntity shangpinEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 商品类型的值
			*/
			public String getShangpinValue() {
				return shangpinValue;
			}
			/**
			* 设置： 商品类型的值
			*/
			public void setShangpinValue(String shangpinValue) {
				this.shangpinValue = shangpinValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}












				//级联表的get和set shangjia
					/**
					* 获取： 商家名称
					*/
					public String getShangjiaName() {
						return shangjiaName;
					}
					/**
					* 设置： 商家名称
					*/
					public void setShangjiaName(String shangjiaName) {
						this.shangjiaName = shangjiaName;
					}
					/**
					* 获取： 联系方式
					*/
					public String getShangjiaPhone() {
						return shangjiaPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setShangjiaPhone(String shangjiaPhone) {
						this.shangjiaPhone = shangjiaPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getShangjiaEmail() {
						return shangjiaEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setShangjiaEmail(String shangjiaEmail) {
						this.shangjiaEmail = shangjiaEmail;
					}
					/**
					* 获取： 营业执照展示
					*/
					public String getShangjiaPhoto() {
						return shangjiaPhoto;
					}
					/**
					* 设置： 营业执照展示
					*/
					public void setShangjiaPhoto(String shangjiaPhoto) {
						this.shangjiaPhoto = shangjiaPhoto;
					}
					/**
					* 获取： 现有余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 现有余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 商家简介
					*/
					public String getShangjiaContent() {
						return shangjiaContent;
					}
					/**
					* 设置： 商家简介
					*/
					public void setShangjiaContent(String shangjiaContent) {
						this.shangjiaContent = shangjiaContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShangjiaDelete() {
						return shangjiaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShangjiaDelete(Integer shangjiaDelete) {
						this.shangjiaDelete = shangjiaDelete;
					}










}
