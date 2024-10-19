package com.entity.view;

import com.entity.ShangpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shangpin_order")
public class ShangpinOrderView extends ShangpinOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单类型的值
		*/
		private String shangpinOrderValue;
		/**
		* 支付类型的值
		*/
		private String shangpinOrderPaymentValue;



		//级联表 address
			/**
			* 收货人
			*/
			private String addressName;
			/**
			* 电话
			*/
			private String addressPhone;
			/**
			* 地址
			*/
			private String addressDizhi;
			/**
			* 是否默认地址
			*/
			private Integer isdefaultTypes;
				/**
				* 是否默认地址的值
				*/
				private String isdefaultValue;

		//级联表 shangpin
			/**
			* 商品名称
			*/
			private String shangpinName;
			/**
			* 商品类型
			*/
			private Integer shangpinTypes;
				/**
				* 商品类型的值
				*/
				private String shangpinValue;
			/**
			* 商品照片
			*/
			private String shangpinPhoto;
			/**
			* 商品库存
			*/
			private Integer ShangpinKucunNumber;
			/**
			* 商品原价
			*/
			private Double shangpinOldMoney;
			/**
			* 商品现价
			*/
			private Double shangpinNewMoney;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer shangpinDelete;
			/**
			* 商品简介
			*/
			private String shangpinContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public ShangpinOrderView() {

	}

	public ShangpinOrderView(ShangpinOrderEntity shangpinOrderEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单类型的值
			*/
			public String getShangpinOrderValue() {
				return shangpinOrderValue;
			}
			/**
			* 设置： 订单类型的值
			*/
			public void setShangpinOrderValue(String shangpinOrderValue) {
				this.shangpinOrderValue = shangpinOrderValue;
			}
			/**
			* 获取： 支付类型的值
			*/
			public String getShangpinOrderPaymentValue() {
				return shangpinOrderPaymentValue;
			}
			/**
			* 设置： 支付类型的值
			*/
			public void setShangpinOrderPaymentValue(String shangpinOrderPaymentValue) {
				this.shangpinOrderPaymentValue = shangpinOrderPaymentValue;
			}




				//级联表的get和set address
					/**
					* 获取： 收货人
					*/
					public String getAddressName() {
						return addressName;
					}
					/**
					* 设置： 收货人
					*/
					public void setAddressName(String addressName) {
						this.addressName = addressName;
					}
					/**
					* 获取： 电话
					*/
					public String getAddressPhone() {
						return addressPhone;
					}
					/**
					* 设置： 电话
					*/
					public void setAddressPhone(String addressPhone) {
						this.addressPhone = addressPhone;
					}
					/**
					* 获取： 地址
					*/
					public String getAddressDizhi() {
						return addressDizhi;
					}
					/**
					* 设置： 地址
					*/
					public void setAddressDizhi(String addressDizhi) {
						this.addressDizhi = addressDizhi;
					}
					/**
					* 获取： 是否默认地址
					*/
					public Integer getIsdefaultTypes() {
						return isdefaultTypes;
					}
					/**
					* 设置： 是否默认地址
					*/
					public void setIsdefaultTypes(Integer isdefaultTypes) {
						this.isdefaultTypes = isdefaultTypes;
					}


						/**
						* 获取： 是否默认地址的值
						*/
						public String getIsdefaultValue() {
							return isdefaultValue;
						}
						/**
						* 设置： 是否默认地址的值
						*/
						public void setIsdefaultValue(String isdefaultValue) {
							this.isdefaultValue = isdefaultValue;
						}





















				//级联表的get和set shangpin
					/**
					* 获取： 商品名称
					*/
					public String getShangpinName() {
						return shangpinName;
					}
					/**
					* 设置： 商品名称
					*/
					public void setShangpinName(String shangpinName) {
						this.shangpinName = shangpinName;
					}
					/**
					* 获取： 商品类型
					*/
					public Integer getShangpinTypes() {
						return shangpinTypes;
					}
					/**
					* 设置： 商品类型
					*/
					public void setShangpinTypes(Integer shangpinTypes) {
						this.shangpinTypes = shangpinTypes;
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
					* 获取： 商品照片
					*/
					public String getShangpinPhoto() {
						return shangpinPhoto;
					}
					/**
					* 设置： 商品照片
					*/
					public void setShangpinPhoto(String shangpinPhoto) {
						this.shangpinPhoto = shangpinPhoto;
					}
					/**
					* 获取： 商品库存
					*/
					public Integer getShangpinKucunNumber() {
						return ShangpinKucunNumber;
					}
					/**
					* 设置： 商品库存
					*/
					public void setShangpinKucunNumber(Integer ShangpinKucunNumber) {
						this.ShangpinKucunNumber = ShangpinKucunNumber;
					}
					/**
					* 获取： 商品原价
					*/
					public Double getShangpinOldMoney() {
						return shangpinOldMoney;
					}
					/**
					* 设置： 商品原价
					*/
					public void setShangpinOldMoney(Double shangpinOldMoney) {
						this.shangpinOldMoney = shangpinOldMoney;
					}
					/**
					* 获取： 商品现价
					*/
					public Double getShangpinNewMoney() {
						return shangpinNewMoney;
					}
					/**
					* 设置： 商品现价
					*/
					public void setShangpinNewMoney(Double shangpinNewMoney) {
						this.shangpinNewMoney = shangpinNewMoney;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
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
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShangpinDelete() {
						return shangpinDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShangpinDelete(Integer shangpinDelete) {
						this.shangpinDelete = shangpinDelete;
					}
					/**
					* 获取： 商品简介
					*/
					public String getShangpinContent() {
						return shangpinContent;
					}
					/**
					* 设置： 商品简介
					*/
					public void setShangpinContent(String shangpinContent) {
						this.shangpinContent = shangpinContent;
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
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
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
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}




}
