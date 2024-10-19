package com.entity.model;

import com.entity.WeixiudengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 维修登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeixiudengjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 维修登记唯一编号
     */
    private String weixiudengjiUuidNumber;


    /**
     * 维修名称
     */
    private String weixiudengjiName;


    /**
     * 维修类型
     */
    private Integer weixiudengjiTypes;


    /**
     * 维修详情
     */
    private String weixiudengjiContent;


    /**
     * 维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date weixiudengjiTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：维修登记唯一编号
	 */
    public String getWeixiudengjiUuidNumber() {
        return weixiudengjiUuidNumber;
    }


    /**
	 * 设置：维修登记唯一编号
	 */
    public void setWeixiudengjiUuidNumber(String weixiudengjiUuidNumber) {
        this.weixiudengjiUuidNumber = weixiudengjiUuidNumber;
    }
    /**
	 * 获取：维修名称
	 */
    public String getWeixiudengjiName() {
        return weixiudengjiName;
    }


    /**
	 * 设置：维修名称
	 */
    public void setWeixiudengjiName(String weixiudengjiName) {
        this.weixiudengjiName = weixiudengjiName;
    }
    /**
	 * 获取：维修类型
	 */
    public Integer getWeixiudengjiTypes() {
        return weixiudengjiTypes;
    }


    /**
	 * 设置：维修类型
	 */
    public void setWeixiudengjiTypes(Integer weixiudengjiTypes) {
        this.weixiudengjiTypes = weixiudengjiTypes;
    }
    /**
	 * 获取：维修详情
	 */
    public String getWeixiudengjiContent() {
        return weixiudengjiContent;
    }


    /**
	 * 设置：维修详情
	 */
    public void setWeixiudengjiContent(String weixiudengjiContent) {
        this.weixiudengjiContent = weixiudengjiContent;
    }
    /**
	 * 获取：维修时间
	 */
    public Date getWeixiudengjiTime() {
        return weixiudengjiTime;
    }


    /**
	 * 设置：维修时间
	 */
    public void setWeixiudengjiTime(Date weixiudengjiTime) {
        this.weixiudengjiTime = weixiudengjiTime;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
