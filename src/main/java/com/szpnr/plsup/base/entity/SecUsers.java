package com.szpnr.plsup.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.szpnr.plsup.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("SEC_USERS")
@KeySequence(value="SEQ_PLSUP_DEFAULT",clazz = Long.class)
public class SecUsers extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 人员内码
     */
    @TableId(value="USER_ID",type = IdType.INPUT)
    private Long userId;

//    /**
//     * 人员内码
//     */
//    @TableField("HR_USER_ID")
//    private Double hrUserId;

    /**
     * 帐号
     */
    @TableField("ACCOUNT")
    private String account;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 姓名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 昵称
     */
    @TableField("NICK_NAME")
    private String nickName;

//    /**
//     * 性别
//     */
//    @TableField("GENDER")
//    private String gender;

    /**
     * 办公室电话
     */
    @TableField("OFFICE_PHONE")
    private String officePhone;

//    /**
//     * 家庭电话
//     */
//    @TableField("HOME_PHONE")
//    private String homePhone;

    /**
     * 移动电话1
     */
    @TableField("MOBILE1")
    private String mobile1;

//    /**
//     * 移动电话2
//     */
//    @TableField("MOBILE2")
//    private String mobile2;

//    /**
//     * 传真
//     */
//    @TableField("FAX")
//    private String fax;

    /**
     * 电子邮件
     */
    @TableField("EMAIL")
    private String email;

//    /**
//     * 备注
//     */
//    @TableField("REMARK")
//    private String remark;

//    /**
//     * 集群网标志
//     */
//    @TableField("MOBILE_TYPE")
//    private String mobileType;
//
//    /**
//     * 是否通讯录用户
//     */
//    @TableField("IS_ADDRESSLIST_USER")
//    private Integer isAddresslistUser;
//
//    /**
//     * 身份证号
//     */
//    @TableField("ID_NO")
//    private String idNo;
//
//    /**
//     * 市民中心人员代码号
//     */
//    @TableField("EMP_EMPNO")
//    private Long empEmpno;
//
//    /**
//     * 原办文用户ID
//     */
//    @TableField("EMP_NO")
//    private Long empNo;
//
//    /**
//     * 生效时间
//     */
//    @TableField("VALID_DATE")
//    private String validDate;
//
//    /**
//     * 用户ID备份
//     */
//    @TableField("USER_ID_BAK")
//    private Long userIdBak;
//
//    /**
//     * 是否图形用户
//     */
//    @TableField("IS_GIS")
//    private String isGis;
//
//    /**
//     * 职位名称
//     */
//    @TableField("DUTY_NAME")
//    private String dutyName;
//
//    /**
//     * 职位编
//     */
//    @TableField("DUTY_CODE")
//    private String dutyCode;
//
//    /**
//     * 用户状态（正常、锁定）
//     */
//    @TableField("STATUS")
//    private String status;
//
//    /**
//     * 用户的即时消息账号
//     */
//    @TableField("IM_ACCOUNT")
//    private String imAccount;
//
//    /**
//     * 上次修改人id
//     */
//    @TableField("MODIFY_USER_ID")
//    private Double modifyUserId;
//
//    /**
//     * 上次修改人姓名
//     */
//    @TableField("MODIFY_USER_NAME")
//    private String modifyUserName;
//
//    /**
//     * 上次修改时间
//     */
//    @TableField("MODIFY_DATE")
//    private Date modifyDate;
//
//    /**
//     * 创建人id
//     */
//    @TableField("CREATE_USER_ID")
//    private Double createUserId;
//
//    /**
//     * 创建人姓名
//     */
//    @TableField("CREATE_USER_NAME")
//    private String createUserName;
//
//    /**
//     * 创建时间
//     */
//    @TableField("CREATE_DATE")
//    private LocalDateTime createDate;
//
//    @TableField("SHOW_MOBILE")
//    private String showMobile;
//
//    /**
//     * 从国土库迁移过来，目的不详
//     */
//    @TableField("USER_ID_ADD")
//    private String userIdAdd;
//
//    /**
//     * 原国土用户的user_id
//     */
//    @TableField("USER_ID_GT")
//    private Double userIdGt;
//
//    /**
//     * 原用户帐号备份，假如国土帐号迁移过来时，该字段用于保存原国土帐号
//     */
//    @TableField("ACCOUNT_BAK")
//    private String accountBak;
//
//    /**
//     * 原组织全称（局、分局、处室）
//     */
//    @TableField("DEP_ORIGIN")
//    private String depOrigin;
//
//    /**
//     * 规划图形系统用户密码，临时建立，不需要时，可删除。
//     */
//    @TableField("PASSWORD_GH")
//    private String passwordGh;
//
//    /**
//     * MD5加密的ldap密码
//     */
//    @TableField("PASSWORD_LDAP")
//    private String passwordLdap;
//
//    /**
//     * 是否为外部用户：空或者0表示委内用户，1 表示是委外用户。
//     */
//    @TableField("IS_OUTSIDE_USER")
//    private Double isOutsideUser;
//
//    /**
//     * 是否公务员，0为否，1为是。默认0
//     */
//    @TableField("IS_CIVIL")
//    private Integer isCivil;
//
//    /**
//     * 用户登录验证方式(ldap,gdca)
//     */
//    @TableField("LOGIN_TYPE")
//    private String loginType;
//
//    /**
//     * 广东CA的key的唯一标识符
//     */
//    @TableField("GDCA_TRUST_ID")
//    private String gdcaTrustId;
//
//    /**
//     * 是否已经初始化CA Key.(0: 否, 1: 是)
//     */
//    @TableField("HAS_INIT_KEY")
//    private String hasInitKey;
//
//    /**
//     * 紧急联系电话
//     */
//    @TableField("EMER_PHONE")
//    private String emerPhone;
//
//    /**
//     * 真实姓名
//     */
//    @TableField("REAL_NAME")
//    private String realName;
//
//    @TableField("ISREAL")
//    private String isreal;
//
//    /**
//     * 行政级别
//     */
//    @TableField("ADMINISTRATIVE_LEVEL")
//    private String administrativeLevel;


}
