package com.szpnr.plsup.base.mapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.szpnr.plsup.base.entity.SecUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szpnr.plsup.common.exception.BaseException;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
public interface SecUsersMapper extends BaseMapper<SecUsers> {
    /**
     * 自定义sql，参数需要加入@param注解注入参数值
     */
    @Select("select  a.group_id,a.group_name,b.type,b.is_leader  from sec_groups a," +
            "sec_user_group_rel b where a.group_id = b.group_id and user_id=#{userId} and b.type='人事'")
    public Map<String, String> getGroupInfoByUserId(@Param("userId") String userId) throws BaseException;

    /**
     * 自定义sql，参数需要加入@param注解注入参数值
     */
    @Select("select perm_code from sec_permissions where perm_id in( " +
            "select perm_id from sec_role_perm_rel where role_id in (" +
            "select role_id from sec_user_role_rel where  user_id = #{userId} ))")
    public List<String> getUserPerm(@Param("userId") String userId) throws BaseException;
}
