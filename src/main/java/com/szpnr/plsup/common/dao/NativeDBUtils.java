package com.szpnr.plsup.common.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.szpnr.plsup.common.utils.SpringContextUtils;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 *
 */
@Component
@Scope("prototype")
public class NativeDBUtils {
    private  Logger logger = LoggerFactory.getLogger(NativeDBUtils.class);

    public NativeDBUtils(){
        getSqlSessionTemplate();
    }

    public void getSqlSessionTemplate() throws BeansException {
        this.sqlSessionTemplate = SpringContextUtils.getBean(SqlSessionTemplate.class);
    }

    public SqlSessionTemplate sqlSessionTemplate;

    protected  SqlSession getNativeSqlSession(){

        return SqlSessionUtils.getSqlSession(sqlSessionTemplate.getSqlSessionFactory(),
                sqlSessionTemplate.getExecutorType(),sqlSessionTemplate.getPersistenceExceptionTranslator());
    }

    protected  void closeNativeSqlSession(SqlSession sqlSession){
        SqlSessionUtils.closeSqlSession(sqlSession,sqlSessionTemplate.getSqlSessionFactory());
    }

    public  JSONObject queryObjectByNateiveSql(String sql,List param){
        JSONObject jsonObject = null;
        SqlSession sqlSession = null;
        PreparedStatement pst = null;
        try {
            sqlSession = getNativeSqlSession();
            pst = sqlSession.getConnection().prepareStatement(sql);
            setPrepareParam(param, pst);//设置参数
            ResultSet resultSet =  pst.executeQuery();
            ResultSetMetaData rsmt = resultSet.getMetaData();
            int colummCount = rsmt.getColumnCount();
            if (resultSet.next()){
                jsonObject = new JSONObject();
                putJSONObject(jsonObject, resultSet, rsmt, colummCount);
            }

        }catch (Exception ex){
            logger.error("出错sql:"+sql);
            logger.error("queryObjectByNateiveSql error",ex);
        }finally {
            if(pst!=null){
                closePreparedStatement(pst);
            }
            if(sqlSession!=null){
                closeNativeSqlSession(sqlSession);
            }
        }

        return jsonObject;
    }

    public  JSONArray queryListByNateiveSql(String sql, List param){
        JSONArray jsonObjects = new JSONArray();
        SqlSession sqlSession = null;
        PreparedStatement pst = null;
        try {
            sqlSession = getNativeSqlSession();
            pst = sqlSession.getConnection().prepareStatement(sql);
            setPrepareParam(param, pst);//设置参数
            ResultSet resultSet =  pst.executeQuery();
            ResultSetMetaData rsmt = resultSet.getMetaData();
            int colummCount = rsmt.getColumnCount();
            while (resultSet.next()){
                JSONObject  jsonObject = new JSONObject();
                putJSONObject(jsonObject, resultSet, rsmt, colummCount);
                jsonObjects.add(jsonObject);
                //System.out.println(jsonObjects.toString());
            }

        }catch (Exception ex){
            logger.error("出错sql:"+sql);
            logger.error("queryListByNateiveSql error",ex);
        }finally {
            if(pst!=null){
                closePreparedStatement(pst);
            }
            if(sqlSession!=null){
                closeNativeSqlSession(sqlSession);
            }
        }

        return jsonObjects;
    }

    private  void putJSONObject(JSONObject jsonObject, ResultSet resultSet, ResultSetMetaData rsmt, int colummCount) throws SQLException {
        for(int i=0;i<colummCount;i++){
            String typeName = rsmt.getColumnTypeName(i+1);
            String colName = rsmt.getColumnName(i+1);
            switch(typeName) {
                case "CHAR":
                case "VARCHAR2":
                    jsonObject.put(colName.toLowerCase(),resultSet.getString(i+1));
                    break;
                case "NUMBER":
                    jsonObject.put(colName.toLowerCase(),resultSet.getString(i+1));
                    break;
                case "DATE":
                    jsonObject.put(colName.toLowerCase(),resultSet.getString(i+1));
                    break;
                case "CLOB":
                    Clob clob = resultSet.getClob(i+1);
                    if(clob!=null){
                        String v = clob.getSubString(1,(int)clob.length());
                        jsonObject.put(colName.toLowerCase(),v);
                    }else{
                        jsonObject.put(colName.toLowerCase(),"");
                    }
                    break;
                case "BLOB":
                    Blob blob = resultSet.getBlob(i+1);
                    if(blob!=null) {
                        byte[] b = blob.getBytes(i, (int) blob.length());
                        jsonObject.put(colName.toLowerCase(),new String(b));
                    }else{
                        jsonObject.put(colName.toLowerCase(),"");
                    }
                    break;
                default:
                    jsonObject.put(colName.toLowerCase(),"");
            }

        }
    }

    private  void setPrepareParam(List param, PreparedStatement pst) throws SQLException {
        for(int i=0;i<param.size();i++){
            Object obj = (Object)param.get(i);
            if(obj instanceof String){
                pst.setString(i+1,(String)obj);
            }else if(obj instanceof Integer){
                pst.setInt(i+1,(Integer) obj);
            }else if(obj instanceof Long){
                pst.setLong(i+1,(Long) obj);
            }else if(obj instanceof Float){
                pst.setFloat(i+1,(Float) obj);
            }else if(obj instanceof Double){
                pst.setDouble(i+1,(Double) obj);
            }else if(obj instanceof Date){
               pst.setDate(i+1,(Date)obj);
            }else{
                pst.setObject(i+1,obj);
            }

        }
    }

    protected  void closePreparedStatement(PreparedStatement pst ){
        try{
            pst.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
