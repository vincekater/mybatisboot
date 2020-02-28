package com.szpnr.plsup.base.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.base.entity.SecUsers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.szpnr.plsup.common.exception.BaseException;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
public interface ISecUsersService extends IService<SecUsers> {
    public int checkPassword(String account,String password,UserInfo userInfo) throws BaseException;
    public UserInfo getUserInfoByAccount(String account)  throws BaseException;
    public UserInfo getUserInfoByID(String userId)  throws BaseException;
//    public Map<String,String> getGroupInfoByUserId(String userId) throws BaseException;
//    public List<String> getUserPerm(String userId) throws BaseException;
}
