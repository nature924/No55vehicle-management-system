package com.entity.vo;

import com.entity.ShigudengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 事故登记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shigudengji")
public class ShigudengjiVO implements Serializable {
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
     * 事故登记唯一编号
     */

    @TableField(value = "shigudengji_uuid_number")
    private String shigudengjiUuidNumber;


    /**
     * 事故名称
     */

    @TableField(value = "shigudengji_name")
    private String shigudengjiName;


    /**
     * 事故类型
     */

    @TableField(value = "shigudengji_types")
    private Integer shigudengjiTypes;


    /**
     * 责任方
     */

    @TableField(value = "zeren_types")
    private Integer zerenTypes;


    /**
     * 事故详情
     */

    @TableField(value = "shigudengji_content")
    private String shigudengjiContent;


    /**
     * 发生时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shigudengji_time")
    private Date shigudengjiTime;


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
	 * 设置：事故登记唯一编号
	 */
    public String getShigudengjiUuidNumber() {
        return shigudengjiUuidNumber;
    }


    /**
	 * 获取：事故登记唯一编号
	 */

    public void setShigudengjiUuidNumber(String shigudengjiUuidNumber) {
        this.shigudengjiUuidNumber = shigudengjiUuidNumber;
    }
    /**
	 * 设置：事故名称
	 */
    public String getShigudengjiName() {
        return shigudengjiName;
    }


    /**
	 * 获取：事故名称
	 */

    public void setShigudengjiName(String shigudengjiName) {
        this.shigudengjiName = shigudengjiName;
    }
    /**
	 * 设置：事故类型
	 */
    public Integer getShigudengjiTypes() {
        return shigudengjiTypes;
    }


    /**
	 * 获取：事故类型
	 */

    public void setShigudengjiTypes(Integer shigudengjiTypes) {
        this.shigudengjiTypes = shigudengjiTypes;
    }
    /**
	 * 设置：责任方
	 */
    public Integer getZerenTypes() {
        return zerenTypes;
    }


    /**
	 * 获取：责任方
	 */

    public void setZerenTypes(Integer zerenTypes) {
        this.zerenTypes = zerenTypes;
    }
    /**
	 * 设置：事故详情
	 */
    public String getShigudengjiContent() {
        return shigudengjiContent;
    }


    /**
	 * 获取：事故详情
	 */

    public void setShigudengjiContent(String shigudengjiContent) {
        this.shigudengjiContent = shigudengjiContent;
    }
    /**
	 * 设置：发生时间
	 */
    public Date getShigudengjiTime() {
        return shigudengjiTime;
    }


    /**
	 * 获取：发生时间
	 */

    public void setShigudengjiTime(Date shigudengjiTime) {
        this.shigudengjiTime = shigudengjiTime;
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
