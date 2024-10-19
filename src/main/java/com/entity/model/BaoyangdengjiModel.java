package com.entity.model;

import com.entity.BaoyangdengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 保养登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaoyangdengjiModel implements Serializable {
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
     * 保养登记唯一编号
     */
    private String baoyangdengjiUuidNumber;


    /**
     * 保养名称
     */
    private String baoyangdengjiName;


    /**
     * 保养类型
     */
    private Integer baoyangdengjiTypes;


    /**
     * 保养详情
     */
    private String baoyangdengjiContent;


    /**
     * 保养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date baoyangdengjiTime;


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
	 * 获取：保养登记唯一编号
	 */
    public String getBaoyangdengjiUuidNumber() {
        return baoyangdengjiUuidNumber;
    }


    /**
	 * 设置：保养登记唯一编号
	 */
    public void setBaoyangdengjiUuidNumber(String baoyangdengjiUuidNumber) {
        this.baoyangdengjiUuidNumber = baoyangdengjiUuidNumber;
    }
    /**
	 * 获取：保养名称
	 */
    public String getBaoyangdengjiName() {
        return baoyangdengjiName;
    }


    /**
	 * 设置：保养名称
	 */
    public void setBaoyangdengjiName(String baoyangdengjiName) {
        this.baoyangdengjiName = baoyangdengjiName;
    }
    /**
	 * 获取：保养类型
	 */
    public Integer getBaoyangdengjiTypes() {
        return baoyangdengjiTypes;
    }


    /**
	 * 设置：保养类型
	 */
    public void setBaoyangdengjiTypes(Integer baoyangdengjiTypes) {
        this.baoyangdengjiTypes = baoyangdengjiTypes;
    }
    /**
	 * 获取：保养详情
	 */
    public String getBaoyangdengjiContent() {
        return baoyangdengjiContent;
    }


    /**
	 * 设置：保养详情
	 */
    public void setBaoyangdengjiContent(String baoyangdengjiContent) {
        this.baoyangdengjiContent = baoyangdengjiContent;
    }
    /**
	 * 获取：保养时间
	 */
    public Date getBaoyangdengjiTime() {
        return baoyangdengjiTime;
    }


    /**
	 * 设置：保养时间
	 */
    public void setBaoyangdengjiTime(Date baoyangdengjiTime) {
        this.baoyangdengjiTime = baoyangdengjiTime;
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
