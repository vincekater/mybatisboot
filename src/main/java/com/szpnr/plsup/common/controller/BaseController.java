package com.szpnr.plsup.common.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@ApiResponses({
        @ApiResponse(code=200,message = "成功,返回ResponseResult对象的JSON格式",response = ResponseResult.class),
        @ApiResponse(code=400,message = "参数没填好"),
        @ApiResponse(code=404,message = "请求路径不对"),
})
public class BaseController {
    protected static final String REDIRECT = "redirect:";
    protected static final String FORWARD = "forward:";

    protected HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
        //return HttpKit.getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
        //return HttpKit.getResponse();
    }

    protected HttpSession getSession() {
        return getHttpServletRequest().getSession();
    }

    protected HttpSession getSession(Boolean flag) {
        return getHttpServletRequest().getSession(flag);
    }

    protected String getPara(String name) {
        return getHttpServletRequest().getParameter(name);
    }

    protected void setRequestAttr(String name, Object value) {
        getHttpServletRequest().setAttribute(name, value);
    }

    protected void addCookie(Cookie cookie) {
        getHttpServletResponse().addCookie(cookie);
    }

    protected String getPath(){
        return getHttpServletRequest().getRequestURI();
    }
}
