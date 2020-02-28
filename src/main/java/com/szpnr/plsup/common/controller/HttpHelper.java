package com.szpnr.plsup.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.szpnr.plsup.common.AxiosAESCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class HttpHelper {
    private static Logger logger = LoggerFactory.getLogger(HttpHelper.class);
    public static final String CIPHERTEXT = "ciphertext";
    public static final String DECODEKEY = "gaxiosencrypt512";
    /**
     * 获取请求Body
     *
     * @param request
     * @return
     */
    public static String getBodyString(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            logger.error("InputStream读取request body内容出错",e);
            //e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("InputStream关闭出错",e);
                    //e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error("BufferedReader关闭出错",e);
                    //e.printStackTrace();
                }
            }
        }
        String result = sb.toString();
        if(result.contains(CIPHERTEXT)){//读取到的数据是加密数据，则尝试解密
            JSONObject jsonObject = JSONObject.parseObject(result);//转为JSON对象
            if(jsonObject.size()==1){//加密传输只允许一个参数
                try{
                    //jsonObject.getString(CIPHERTEXT)获取加密内容
                    result =  AxiosAESCode.decrypt(jsonObject.getString(CIPHERTEXT),DECODEKEY);//获取加密内容并解密
                }catch (Exception ex){//解密不成功
                    logger.error("前端加密内容解密出错",ex);
                    result="{\"REQUEST_ERROR\",\"非法请求!\"}";
                }
                return result;
            }else{
                result="{\"REQUEST_ERROR\",\"非法请求!\"}";
            }
        }
        return result;
    }
}
