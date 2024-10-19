package com.entity.vo;

import com.entity.BaoyangdengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 保养登记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("baoyangdengji")
public class BaoyangdengjiVO implements Serializable {
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
     * 保养登记唯一编号
     */

    @TableField(value = "baoyangdengji_uuid_number")
    private String baoyangdengjiUuidNumber;


    /**
     * 保养名称
     */

    @TableField(value = "baoyangdengji_name")
    private String baoyangdengjiName;


    /**
     * 保养类型
     */

    @TableField(value = "baoyangdengji_types")
    private Integer baoyangdengjiTypes;


    /**
     * 保养详情
     */

    @TableField(value = "baoyangdengji_content")
    private String baoyangdengjiContent;


    /**
     * 保养时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "baoyangdengji_time")
    private Date baoyangdengjiTime;


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
	 * 设置：保养登记唯一编号
	 */
    public String getBaoyangdengjiUuidNumber() {
        return baoyangdengjiUuidNumber;
    }


    /**
	 * 获取：保养登记唯一编号
	 */

    public void setBaoyangdengjiUuidNumber(String baoyangdengjiUuidNumber) {
        this.baoyangdengjiUuidNumber = baoyangdengjiUuidNumber;
    }
    /**
	 * 设置：保养名称
	 */
    public String getBaoyangdengjiName() {
        return baoyangdengjiName;
    }


    /**
	 * 获取：保养名称
	 */

    public void setBaoyangdengjiName(String baoyangdengjiName) {
        this.baoyangdengjiName = baoyangdengjiName;
    }
    /**
	 * 设置：保养类型
	 */
    public Integer getBaoyangdengjiTypes() {
        return baoyangdengjiTypes;
    }


    /**
	 * 获取：保养类型
	 */

    public void setBaoyangdengjiTypes(Integer baoyangdengjiTypes) {
        this.baoyangdengjiTypes = baoyangdengjiTypes;
    }
    /**
	 * 设置：保养详情
	 */
    public String getBaoyangdengjiContent() {
        return baoyangdengjiContent;
    }


    /**
	 * 获取：保养详情
	 */

    public void setBaoyangdengjiContent(String baoyangdengjiContent) {
        this.baoyangdengjiContent = baoyangdengjiContent;
    }
    /**
	 * 设置：保养时间
	 */
    public Date getBaoyangdengjiTime() {
        return baoyangdengjiTime;
    }


    /**
	 * 获取：保养时间
	 */

    public void setBaoyangdengjiTime(Date baoyangdengjiTime) {
        this.baoyangdengjiTime = baoyangdengjiTime;
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
