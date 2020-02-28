package com.szpnr.plsup.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.szpnr.plsup.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 区域设置表
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PLSUP_LOCATION")
@KeySequence(value="SEQ_PLSUP_DEFAULT",clazz = Long.class)
public class PlsupLocation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 区域ID
     */
    @TableId(value = "LOCATION_ID",type = IdType.INPUT)
    private Long locationId;

    /**
     * 区域名称
     */
    @TableField("LOCATION_NAME")
    private String locationName;

    /**
     * 区域代码
     */
    @TableField("LOCATION_CODE")
    private String locationCode;

    /**
     * 区域级别
     */
    @TableField("LOCATION_LEVEL")
    private String locationLevel;

    /**
     * 所属区域
     */
    @TableField("PARENT_CODE")
    private String parentCode;

    /**
     * 区域代码(图形)
     */
    @TableField("LOCATION_CODE_JCGIS")
    private String locationCodeJcgis;

    /**
     * 区域代码(IBMS)
     */
    @TableField("LOCATION_CODE_IBMS1")
    private String locationCodeIbms1;

    /**
     * 区域代码(IBMS)
     */
    @TableField("LOCATION_CODE_IBMS2")
    private String locationCodeIbms2;

    /**
     * 是否注销
     */
    @TableField("IS_DEL")
    private String isDel;

    /**
     * 区域地址
     */
    @TableField("LOCATION_ADDR")
    private String locationAddr;

    /**
     * 区域电话
     */
    @TableField("LOCATION_TEL")
    private String locationTel;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 区代码(IBMS)
     */
    @TableField("LOCATION_CODE_IBMS_ZONE")
    private String locationCodeIbmsZone;

    /**
     * 街道代码(IBMS)
     */
    @TableField("LOCATION_CODE_IBMS_SUB")
    private String locationCodeIbmsSub;

    /**
     * 区域面积
     */
    @TableField("LOCATION_AREA")
    private Double locationArea;

    /**
     * 处理系统区域编码
     */
    @TableField("LOCATION_IBMS_CODE")
    private String locationIbmsCode;

    /**
     * 处理系统区域级别，S-市级、Q-区级、J-街道级、G-社区级
     */
    @TableField("LOCATION_IBMS_LEVEL")
    private String locationIbmsLevel;


}
