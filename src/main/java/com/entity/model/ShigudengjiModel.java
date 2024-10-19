package com.entity.model;

import com.entity.ShigudengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 事故登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShigudengjiModel implements Serializable {
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
     * 事故登记唯一编号
     */
    private String shigudengjiUuidNumber;


    /**
     * 事故名称
     */
    private String shigudengjiName;


    /**
     * 事故类型
     */
    private Integer shigudengjiTypes;


    /**
     * 责任方
     */
    private Integer zerenTypes;


    /**
     * 事故详情
     */
    private String shigudengjiContent;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shigudengjiTime;


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
	 * 获取：事故登记唯一编号
	 */
    public String getShigudengjiUuidNumber() {
        return shigudengjiUuidNumber;
    }


    /**
	 * 设置：事故登记唯一编号
	 */
    public void setShigudengjiUuidNumber(String shigudengjiUuidNumber) {
        this.shigudengjiUuidNumber = shigudengjiUuidNumber;
    }
    /**
	 * 获取：事故名称
	 */
    public String getShigudengjiName() {
        return shigudengjiName;
    }


    /**
	 * 设置：事故名称
	 */
    public void setShigudengjiName(String shigudengjiName) {
        this.shigudengjiName = shigudengjiName;
    }
    /**
	 * 获取：事故类型
	 */
    public Integer getShigudengjiTypes() {
        return shigudengjiTypes;
    }


    /**
	 * 设置：事故类型
	 */
    public void setShigudengjiTypes(Integer shigudengjiTypes) {
        this.shigudengjiTypes = shigudengjiTypes;
    }
    /**
	 * 获取：责任方
	 */
    public Integer getZerenTypes() {
        return zerenTypes;
    }


    /**
	 * 设置：责任方
	 */
    public void setZerenTypes(Integer zerenTypes) {
        this.zerenTypes = zerenTypes;
    }
    /**
	 * 获取：事故详情
	 */
    public String getShigudengjiContent() {
        return shigudengjiContent;
    }


    /**
	 * 设置：事故详情
	 */
    public void setShigudengjiContent(String shigudengjiContent) {
        this.shigudengjiContent = shigudengjiContent;
    }
    /**
	 * 获取：发生时间
	 */
    public Date getShigudengjiTime() {
        return shigudengjiTime;
    }


    /**
	 * 设置：发生时间
	 */
    public void setShigudengjiTime(Date shigudengjiTime) {
        this.shigudengjiTime = shigudengjiTime;
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
