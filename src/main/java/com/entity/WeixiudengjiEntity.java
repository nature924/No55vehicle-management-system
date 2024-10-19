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
 * 维修登记
 *
 * @author 
 * @email
 */
@TableName("weixiudengji")
public class WeixiudengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeixiudengjiEntity() {

	}

	public WeixiudengjiEntity(T t) {
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
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 员工
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 维修登记唯一编号
     */
    @TableField(value = "weixiudengji_uuid_number")

    private String weixiudengjiUuidNumber;


    /**
     * 维修名称
     */
    @TableField(value = "weixiudengji_name")

    private String weixiudengjiName;


    /**
     * 维修类型
     */
    @TableField(value = "weixiudengji_types")

    private Integer weixiudengjiTypes;


    /**
     * 维修详情
     */
    @TableField(value = "weixiudengji_content")

    private String weixiudengjiContent;


    /**
     * 维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "weixiudengji_time")

    private Date weixiudengjiTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：维修登记唯一编号
	 */
    public String getWeixiudengjiUuidNumber() {
        return weixiudengjiUuidNumber;
    }


    /**
	 * 获取：维修登记唯一编号
	 */

    public void setWeixiudengjiUuidNumber(String weixiudengjiUuidNumber) {
        this.weixiudengjiUuidNumber = weixiudengjiUuidNumber;
    }
    /**
	 * 设置：维修名称
	 */
    public String getWeixiudengjiName() {
        return weixiudengjiName;
    }


    /**
	 * 获取：维修名称
	 */

    public void setWeixiudengjiName(String weixiudengjiName) {
        this.weixiudengjiName = weixiudengjiName;
    }
    /**
	 * 设置：维修类型
	 */
    public Integer getWeixiudengjiTypes() {
        return weixiudengjiTypes;
    }


    /**
	 * 获取：维修类型
	 */

    public void setWeixiudengjiTypes(Integer weixiudengjiTypes) {
        this.weixiudengjiTypes = weixiudengjiTypes;
    }
    /**
	 * 设置：维修详情
	 */
    public String getWeixiudengjiContent() {
        return weixiudengjiContent;
    }


    /**
	 * 获取：维修详情
	 */

    public void setWeixiudengjiContent(String weixiudengjiContent) {
        this.weixiudengjiContent = weixiudengjiContent;
    }
    /**
	 * 设置：维修时间
	 */
    public Date getWeixiudengjiTime() {
        return weixiudengjiTime;
    }


    /**
	 * 获取：维修时间
	 */

    public void setWeixiudengjiTime(Date weixiudengjiTime) {
        this.weixiudengjiTime = weixiudengjiTime;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Weixiudengji{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", weixiudengjiUuidNumber=" + weixiudengjiUuidNumber +
            ", weixiudengjiName=" + weixiudengjiName +
            ", weixiudengjiTypes=" + weixiudengjiTypes +
            ", weixiudengjiContent=" + weixiudengjiContent +
            ", weixiudengjiTime=" + weixiudengjiTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
