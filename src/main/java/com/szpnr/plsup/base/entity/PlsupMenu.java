package com.szpnr.plsup.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.szpnr.plsup.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PLSUP_MENU")
@KeySequence(value="SEQ_PLSUP_DEFAULT",clazz = Long.class)
public class PlsupMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @TableField(exist=false)
    private boolean expanded = false;
    @TableField(exist=false)
    private boolean isshow = false;
    @TableField(exist=false)
    private List<PlsupMenu> subMenu;
    /**
     * 表ID
     */
    @TableId(value = "MENU_ID",type = IdType.INPUT)
    private Long menuId;

    /**
     * 父菜单ID
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField("TITLE")
    private String title;

    /**
     * 访问路径
     */
    @TableField("PATH")
    private String path;

    /**
     * 菜单图标路径
     */
    @TableField("ICONPATH")
    private String iconpath;

    /**
     * 权限码
     */
    @TableField("PERM_CODE")
    private String permCode;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 排序序号
     */
    @TableField("SEQ")
    private Integer seq;

    /**
     * 组件路径
     */
    @TableField("COMPONENT")
    private String component;


}
