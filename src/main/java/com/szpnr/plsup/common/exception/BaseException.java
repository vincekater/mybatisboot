package com.szpnr.plsup.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础异常，系統其他異常由此擴展
 *
 * @author dengsy
 */
@SuppressWarnings("serial")
public class BaseException extends Exception{
    private static Logger logger = LoggerFactory.getLogger(BaseException.class);
    /**
     * 构造函数
     */
    public BaseException(String message) {
        this(message, null);
        logger.error(message);
    }

    /**
     * 构造函数
     */
    public BaseException(Throwable cause) {
        super(null, cause);
        logger.error(cause.getMessage(),cause);
    }

    /**
     * 构造函数
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message,cause);
    }
}
