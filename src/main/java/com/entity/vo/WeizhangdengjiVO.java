package com.entity.vo;

import com.entity.WeizhangdengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 违章登记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weizhangdengji")
public class WeizhangdengjiVO implements Serializable {
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
     * 违章登记唯一编号
     */

    @TableField(value = "weizhangdengji_uuid_number")
    private String weizhangdengjiUuidNumber;


    /**
     * 违章名称
     */

    @TableField(value = "weizhangdengji_name")
    private String weizhangdengjiName;


    /**
     * 违章类型
     */

    @TableField(value = "weizhangdengji_types")
    private Integer weizhangdengjiTypes;


    /**
     * 违章详情
     */

    @TableField(value = "weizhangdengji_content")
    private String weizhangdengjiContent;


    /**
     * 处罚详情
     */

    @TableField(value = "chufa_content")
    private String chufaContent;


    /**
     * 违章时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "weizhangdengji_time")
    private Date weizhangdengjiTime;


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
	 * 设置：违章登记唯一编号
	 */
    public String getWeizhangdengjiUuidNumber() {
        return weizhangdengjiUuidNumber;
    }


    /**
	 * 获取：违章登记唯一编号
	 */

    public void setWeizhangdengjiUuidNumber(String weizhangdengjiUuidNumber) {
        this.weizhangdengjiUuidNumber = weizhangdengjiUuidNumber;
    }
    /**
	 * 设置：违章名称
	 */
    public String getWeizhangdengjiName() {
        return weizhangdengjiName;
    }


    /**
	 * 获取：违章名称
	 */

    public void setWeizhangdengjiName(String weizhangdengjiName) {
        this.weizhangdengjiName = weizhangdengjiName;
    }
    /**
	 * 设置：违章类型
	 */
    public Integer getWeizhangdengjiTypes() {
        return weizhangdengjiTypes;
    }


    /**
	 * 获取：违章类型
	 */

    public void setWeizhangdengjiTypes(Integer weizhangdengjiTypes) {
        this.weizhangdengjiTypes = weizhangdengjiTypes;
    }
    /**
	 * 设置：违章详情
	 */
    public String getWeizhangdengjiContent() {
        return weizhangdengjiContent;
    }


    /**
	 * 获取：违章详情
	 */

    public void setWeizhangdengjiContent(String weizhangdengjiContent) {
        this.weizhangdengjiContent = weizhangdengjiContent;
    }
    /**
	 * 设置：处罚详情
	 */
    public String getChufaContent() {
        return chufaContent;
    }


    /**
	 * 获取：处罚详情
	 */

    public void setChufaContent(String chufaContent) {
        this.chufaContent = chufaContent;
    }
    /**
	 * 设置：违章时间
	 */
    public Date getWeizhangdengjiTime() {
        return weizhangdengjiTime;
    }


    /**
	 * 获取：违章时间
	 */

    public void setWeizhangdengjiTime(Date weizhangdengjiTime) {
        this.weizhangdengjiTime = weizhangdengjiTime;
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
