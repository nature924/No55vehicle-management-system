package com.entity.vo;

import com.entity.WeixiudengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 维修登记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weixiudengji")
public class WeixiudengjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
