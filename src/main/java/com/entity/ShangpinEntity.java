package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 商品信息
 *
 * @author 
 * @email
 */
@TableName("shangpin")
public class ShangpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpinEntity() {

	}

	public ShangpinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 商家
     */
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


    /**
     * 商品名称
     */
    @TableField(value = "shangpin_name")

    private String shangpinName;


    /**
     * 商品类型
     */
    @TableField(value = "shangpin_types")

    private Integer shangpinTypes;


    /**
     * 商品照片
     */
    @TableField(value = "shangpin_photo")

    private String shangpinPhoto;


    /**
     * 商品库存
     */
    @TableField(value = "Shangpin_kucun_number")

    private Integer shangpinKucunNumber;


    /**
     * 商品原价
     */
    @TableField(value = "shangpin_old_money")

    private Double shangpinOldMoney;


    /**
     * 商品现价
     */
    @TableField(value = "shangpin_new_money")

    private Double shangpinNewMoney;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "shangpin_delete")

    private Integer shangpinDelete;


    /**
     * 商品简介
     */
    @TableField(value = "shangpin_content")

    private String shangpinContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：商品名称
	 */
    public String getShangpinName() {
        return shangpinName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setShangpinName(String shangpinName) {
        this.shangpinName = shangpinName;
    }
    /**
	 * 设置：商品类型
	 */
    public Integer getShangpinTypes() {
        return shangpinTypes;
    }


    /**
	 * 获取：商品类型
	 */

    public void setShangpinTypes(Integer shangpinTypes) {
        this.shangpinTypes = shangpinTypes;
    }
    /**
	 * 设置：商品照片
	 */
    public String getShangpinPhoto() {
        return shangpinPhoto;
    }


    /**
	 * 获取：商品照片
	 */

    public void setShangpinPhoto(String shangpinPhoto) {
        this.shangpinPhoto = shangpinPhoto;
    }
    /**
	 * 设置：商品库存
	 */
    public Integer getShangpinKucunNumber() {
        return shangpinKucunNumber;
    }


    /**
	 * 获取：商品库存
	 */

    public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
        this.shangpinKucunNumber = shangpinKucunNumber;
    }
    /**
	 * 设置：商品原价
	 */
    public Double getShangpinOldMoney() {
        return shangpinOldMoney;
    }


    /**
	 * 获取：商品原价
	 */

    public void setShangpinOldMoney(Double shangpinOldMoney) {
        this.shangpinOldMoney = shangpinOldMoney;
    }
    /**
	 * 设置：商品现价
	 */
    public Double getShangpinNewMoney() {
        return shangpinNewMoney;
    }


    /**
	 * 获取：商品现价
	 */

    public void setShangpinNewMoney(Double shangpinNewMoney) {
        this.shangpinNewMoney = shangpinNewMoney;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShangpinDelete() {
        return shangpinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShangpinDelete(Integer shangpinDelete) {
        this.shangpinDelete = shangpinDelete;
    }
    /**
	 * 设置：商品简介
	 */
    public String getShangpinContent() {
        return shangpinContent;
    }


    /**
	 * 获取：商品简介
	 */

    public void setShangpinContent(String shangpinContent) {
        this.shangpinContent = shangpinContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shangpin{" +
            "id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", shangpinName=" + shangpinName +
            ", shangpinTypes=" + shangpinTypes +
            ", shangpinPhoto=" + shangpinPhoto +
            ", shangpinKucunNumber=" + shangpinKucunNumber +
            ", shangpinOldMoney=" + shangpinOldMoney +
            ", shangpinNewMoney=" + shangpinNewMoney +
            ", shangxiaTypes=" + shangxiaTypes +
            ", shangpinDelete=" + shangpinDelete +
            ", shangpinContent=" + shangpinContent +
            ", createTime=" + createTime +
        "}";
    }
}
