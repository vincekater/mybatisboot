package com.szpnr.plsup.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.base.entity.SecUsers;
import com.szpnr.plsup.base.mapper.SecUsersMapper;
import com.szpnr.plsup.base.service.ISecUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szpnr.plsup.common.exception.BaseException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
@Service
public class SecUsersServiceImpl extends ServiceImpl<SecUsersMapper, SecUsers> implements ISecUsersService {
    @Override
    public int checkPassword(String account, String password, UserInfo userInfo) throws BaseException {
        int checkCode=-2;
        QueryWrapper<SecUsers> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SecUsers::getAccount,account);
        SecUsers secUsers = getOne(queryWrapper);
        if(secUsers!=null && password.equals(secUsers.getPassword())){
//            userInfo.setUserName(secUsers.getUserName());
//            userInfo.setUserID(String.valueOf(secUsers.getUserId()));
//            userInfo.setUserAccount(account);
//            userInfo.setMobileTel(secUsers.getMobile1());
//            userInfo.setPassword(password);
            changeSecUsersToUserInfo(secUsers, userInfo);//将secUsers转换成userInfo对象
            checkCode=0;
        }else{
            checkCode = -1;
        }
        return checkCode;
    }

    @Override
    public UserInfo getUserInfoByAccount(String account) throws BaseException {
        QueryWrapper<SecUsers> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SecUsers::getAccount,account);
        SecUsers secUsers = getOne(queryWrapper);
        UserInfo userInfo = new UserInfo();
        changeSecUsersToUserInfo(secUsers, userInfo);//将secUsers转换成userInfo对象
        return userInfo;
    }

    @Override
    public UserInfo getUserInfoByID(String userId) throws BaseException {
//        QueryWrapper<SecUsers> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(SecUsers::getUserId,Long.parseLong(userId));
        SecUsers secUsers = getById(Long.parseLong(userId));
        UserInfo userInfo = new UserInfo();
        changeSecUsersToUserInfo(secUsers, userInfo);//将secUsers转换成userInfo对象
        return userInfo;
    }

    private void changeSecUsersToUserInfo(SecUsers secUsers, UserInfo userInfo) throws BaseException {
        userInfo.setUserID(secUsers.getUserId().toString());
        userInfo.setPassword(secUsers.getPassword());
        userInfo.setUserAccount(secUsers.getAccount());
        userInfo.setUserName(secUsers.getUserName());
        userInfo.setMobileTel(secUsers.getMobile1());
        Map<String,String> groupMap= getBaseMapper().getGroupInfoByUserId(secUsers.getUserId().toString());
        if(groupMap!=null){
            userInfo.setOrganID(groupMap.get("group_id"));
            userInfo.setOrganName(groupMap.get("group_name"));
            if ("1".equals(groupMap.get("is_leader"))) {
                userInfo.setOrganLeader(true);
            }
        }
        //获取用户权限
        List<String> prems = getBaseMapper().getUserPerm(userInfo.getUserID());
//        List userPermList = new ArrayList();
//        for (int i = 0; i < array.size(); i++) {
//            //JSONObject obj = (JSONObject) array.get(i);
//            userPermList.add(prems);
//
//        }
        userInfo.setUserPermList(prems);
    }

//
//    @Override
//    public JSONObject getGroupInfoByUserId(String userId) throws BaseException {
//        JSONObject jsonObject = null;
//        String sql = "select  a.group_id,a.group_name,b.type,b.is_leader  from sec_groups a , " +
//                "sec_user_group_rel b where a.group_id = b.group_id and user_id=? and b.type='人事'";
//        SqlSession sqlSession =null;
//        try{
//            sqlSession = sqlSessionBatch();
//            PreparedStatement pst = null;
//            List<String> param = new ArrayList<>();
//            param.add(userId);
//            pst = sqlSession.getConnection().prepareStatement(sql);//获取数据库连接，执行原生sql
//            setPrepareParam(param, pst);//设置参数
//            ResultSet resultSet =  pst.executeQuery();
//            ResultSetMetaData rsmt = resultSet.getMetaData();
//            int colummCount = rsmt.getColumnCount();
//            if (resultSet.next()){
//                jsonObject = new JSONObject();
//                putJSONObject(jsonObject, resultSet, rsmt, colummCount);
//            }
//        }catch (Exception ex){
//            throw new BaseException("执行sql出错:"+sql,ex);
//        }finally {
//            if(sqlSession!=null){
//                closeSqlSession(sqlSession);
//            }
//        }
//
//        return jsonObject;
//    }
//
//    @Override
//    public JSONArray getUserPerm(String userId) throws BaseException {
//        JSONArray jsonObjects = new JSONArray();
//        String sql = "select perm_code from sec_permissions where perm_id in( " +
//                "select perm_id from sec_role_perm_rel where role_id in (" +
//                "select role_id from sec_user_role_rel where  user_id = ? ))";
//        SqlSession sqlSession =null;
//        try{
//            sqlSession = sqlSessionBatch();
//            sqlSession.getConnection().prepareStatement(sql);
//            PreparedStatement pst = null;
//            List<String> param = new ArrayList<>();
//            param.add(userId);
//            pst = sqlSession.getConnection().prepareStatement(sql);//获取数据库连接，执行原生sql
//            setPrepareParam(param, pst);//设置参数
//            ResultSet resultSet =  pst.executeQuery();
//            ResultSetMetaData rsmt = resultSet.getMetaData();
//            int colummCount = rsmt.getColumnCount();
//            while (resultSet.next()){
//                JSONObject  jsonObject = new JSONObject();
//                putJSONObject(jsonObject, resultSet, rsmt, colummCount);
//                jsonObjects.add(jsonObject);
//                //System.out.println(jsonObjects.toString());
//            }
//        }catch (Exception ex){
//            throw new BaseException("执行sql出错:"+sql,ex);
//        }finally {
//            if(sqlSession!=null){
//                closeSqlSession(sqlSession);
//            }
//        }
//
//        return jsonObjects;
//    }
//
//    private  void putJSONObject(JSONObject jsonObject, ResultSet resultSet, ResultSetMetaData rsmt, int colummCount) throws SQLException {
//        for(int i=0;i<colummCount;i++){
//            String typeName = rsmt.getColumnTypeName(i+1);
//            String colName = rsmt.getColumnName(i+1);
//            switch(typeName) {
//                case "CHAR":
//                case "VARCHAR2":
//                    jsonObject.put(colName.toLowerCase(),resultSet.getString(i+1));
//                    break;
//                case "NUMBER":
//                    jsonObject.put(colName.toLowerCase(),resultSet.getString(i+1));
//                    break;
//                case "DATE":
//                    jsonObject.put(colName.toLowerCase(),resultSet.getString(i+1));
//                    break;
//                case "CLOB":
//                    Clob clob = resultSet.getClob(i+1);
//                    if(clob!=null){
//                        String v = clob.getSubString(1,(int)clob.length());
//                        jsonObject.put(colName.toLowerCase(),v);
//                    }else{
//                        jsonObject.put(colName.toLowerCase(),"");
//                    }
//                    break;
//                case "BLOB":
//                    Blob blob = resultSet.getBlob(i+1);
//                    if(blob!=null) {
//                        byte[] b = blob.getBytes(i, (int) blob.length());
//                        jsonObject.put(colName.toLowerCase(),new String(b));
//                    }else{
//                        jsonObject.put(colName.toLowerCase(),"");
//                    }
//                    break;
//                default:
//                    jsonObject.put(colName.toLowerCase(),"");
//            }
//
//        }
//    }
//
//    private  void setPrepareParam(List param, PreparedStatement pst) throws SQLException {
//        for(int i=0;i<param.size();i++){
//            Object obj = (Object)param.get(i);
//            if(obj instanceof String){
//                pst.setString(i+1,(String)obj);
//            }else if(obj instanceof Integer){
//                pst.setInt(i+1,(Integer) obj);
//            }else if(obj instanceof Long){
//                pst.setLong(i+1,(Long) obj);
//            }else if(obj instanceof Float){
//                pst.setFloat(i+1,(Float) obj);
//            }else if(obj instanceof Double){
//                pst.setDouble(i+1,(Double) obj);
//            }else if(obj instanceof Date){
//                pst.setDate(i+1,(Date)obj);
//            }else{
//                pst.setObject(i+1,obj);
//            }
//
//        }
//    }
}
