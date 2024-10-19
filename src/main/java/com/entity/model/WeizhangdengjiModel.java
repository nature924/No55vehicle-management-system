package com.entity.model;

import com.entity.WeizhangdengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 违章登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeizhangdengjiModel implements Serializable {
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
     * 违章登记唯一编号
     */
    private String weizhangdengjiUuidNumber;


    /**
     * 违章名称
     */
    private String weizhangdengjiName;


    /**
     * 违章类型
     */
    private Integer weizhangdengjiTypes;


    /**
     * 违章详情
     */
    private String weizhangdengjiContent;


    /**
     * 处罚详情
     */
    private String chufaContent;


    /**
     * 违章时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date weizhangdengjiTime;


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
	 * 获取：违章登记唯一编号
	 */
    public String getWeizhangdengjiUuidNumber() {
        return weizhangdengjiUuidNumber;
    }


    /**
	 * 设置：违章登记唯一编号
	 */
    public void setWeizhangdengjiUuidNumber(String weizhangdengjiUuidNumber) {
        this.weizhangdengjiUuidNumber = weizhangdengjiUuidNumber;
    }
    /**
	 * 获取：违章名称
	 */
    public String getWeizhangdengjiName() {
        return weizhangdengjiName;
    }


    /**
	 * 设置：违章名称
	 */
    public void setWeizhangdengjiName(String weizhangdengjiName) {
        this.weizhangdengjiName = weizhangdengjiName;
    }
    /**
	 * 获取：违章类型
	 */
    public Integer getWeizhangdengjiTypes() {
        return weizhangdengjiTypes;
    }


    /**
	 * 设置：违章类型
	 */
    public void setWeizhangdengjiTypes(Integer weizhangdengjiTypes) {
        this.weizhangdengjiTypes = weizhangdengjiTypes;
    }
    /**
	 * 获取：违章详情
	 */
    public String getWeizhangdengjiContent() {
        return weizhangdengjiContent;
    }


    /**
	 * 设置：违章详情
	 */
    public void setWeizhangdengjiContent(String weizhangdengjiContent) {
        this.weizhangdengjiContent = weizhangdengjiContent;
    }
    /**
	 * 获取：处罚详情
	 */
    public String getChufaContent() {
        return chufaContent;
    }


    /**
	 * 设置：处罚详情
	 */
    public void setChufaContent(String chufaContent) {
        this.chufaContent = chufaContent;
    }
    /**
	 * 获取：违章时间
	 */
    public Date getWeizhangdengjiTime() {
        return weizhangdengjiTime;
    }


    /**
	 * 设置：违章时间
	 */
    public void setWeizhangdengjiTime(Date weizhangdengjiTime) {
        this.weizhangdengjiTime = weizhangdengjiTime;
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
