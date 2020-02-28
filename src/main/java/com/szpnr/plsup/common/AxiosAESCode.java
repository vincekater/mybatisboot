package com.szpnr.plsup.common;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AxiosAESCode {
    private static Logger logger = LoggerFactory.getLogger(AxiosAESCode.class);
    /**
     * AES加密
     * @param content 加密内容
     * @param password 秘钥
     * */
    public static String encrypt(String content,String password){
        String string = null;
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,new SecretKeySpec(password.getBytes(),"AES"));
            byte[] result = cipher.doFinal(content.getBytes("utf-8"));
            return Base64.encodeBase64String(result);
        }catch (Exception ex){
            logger.error("加密内容出错",ex);
            //ex.printStackTrace();
        }
        return string;
    }

    /**
     * AES解密
     * @param content 解密内容
     * @param password 秘钥
     * */
    public static String decrypt(String content,String password){
        String string = null;
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,new SecretKeySpec(password.getBytes(),"AES"));
            //System.out.println(new String(Base64.decodeBase64(content)));
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            //System.out.println(new String(result,"utf-8"));
            return new String(result,"utf-8");
        }catch (Exception ex){
            logger.error("解密内容出错",ex);
            //ex.printStackTrace();
        }
        return string;
    }
}
