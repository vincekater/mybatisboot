package com.szpnr.plsup.base.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.szpnr.plsup.common.controller.ResponseResult;
import com.szpnr.plsup.common.controller.BodyReaderHttpServletRequestWrapper;
import com.szpnr.plsup.common.controller.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
@ComponentScan  //将filter交给容器赖处理，让filter起作用
@WebFilter(filterName ="charFilter",urlPatterns = "/*")
public class CharFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(CharFilter.class);
    private String encoding = "utf-8";
    private static final String[] legalNames= new String[]{"http"};
    private static final String[] illegalChars = new String[]{"|","$","@","'","\"","\'","\\\"",
            ">","CR","LF","\\","\\\\",";","script","insert ","select ",
            "delete ","update ","declare ","iframe","alert","atestu","xxs","svg"};
    //private String[] domainNames;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
//        encoding = filterConfig.getInitParameter("encoding");
//        legalNames = filterConfig.getInitParameter("legalNames").split(",");
//        illegalChars = filterConfig.getInitParameter("illegalChars").split(",");
        //domainNames  = filterConfig.getInitParameter("domainNames").split(",");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
//        encoding = null;
//        legalNames = null;
//        illegalChars = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        //非法状态 true：非法，false：合法
        //System.out.println("do filter ********************");
        boolean illeagalStatus = false;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 防止流读取一次后就没有了, 所以需要将流继续写出去，提供后续使用
        String contentType = req.getContentType();
        ServletRequest requestWrapper = null;
        //res.setHeader("Content-Security-Policy", "default-src 'self'");//网页安全策略CSP设置
        //res.setHeader("X-Frame-Options","SAMEORIGIN");//DENY,frame无法加载页面,SAMEORIGIN可以在相同域名页面的frame中显示
        res.setHeader("X-Xss-Protection", "1;mode=block");//启用XSS过滤,如果检测到跨站点脚本攻击，浏览器将直接阻止页面加载。
        res.setHeader("X-Content-Type-Options", "nosniff");//阻止mime类型嗅探
//        String servName = request.getServerName();
//        String tempURL2 = req.getRequestURI();
        req.setCharacterEncoding(encoding);
        String tempURL = req.getRequestURI();
//        int serverPort = request.getServerPort();
        String method = req.getMethod();
        if ("get".equals(method.toLowerCase()) || "post".equals(method.toLowerCase())
                || "head".equals(method.toLowerCase()) || "options".equals(method.toLowerCase())
                || "put".equals(method.toLowerCase()) || "patch".equals(method.toLowerCase())
                || "delete".equals(method.toLowerCase()) || "trace".equals(method.toLowerCase())
                || "connect".equals(method.toLowerCase())) {//允许的http请求方法
            illeagalStatus = false;
        } else {
            illeagalStatus = true;
        }
        // 链接来源地址
        String referer = req.getHeader("referer");

        if (StringUtils.isEmpty(referer)) {
            referer = req.getHeader("Referer");
        }
        //if (illeagalStatus || !StringUtils.isEmpty(referer) && !referer.contains(request.getServerName())) {
        //    illeagalStatus = true;
        //} else {
            illeagalStatus = false;
            //必须手动指定编码
            Enumeration params = null;
            Map<String, String> formfields = null;
            //是否执行过滤 true，执行过滤，false：不执行过滤
            boolean executable = true;
            String illegalChar = "";
            //如果是文件上传的请求，需要特殊解析
            if (contentType != null && contentType.startsWith("multipart/form-data")) {//上传文件另外解析
//                FilereadUtil frut = new FilereadUtil();
//                List<Map> lis = frut.readRequest(req);
//                if (lis != null) {
//                    formfields = lis.get(0);
//                }
//                if (formfields != null && formfields.size() > 0) {
//                    //判断文件上传请求的相关参数值是否合法
//                    illeagalStatus = isIlleagalStatus(formfields, illeagalStatus);
//                }
            } else {
                //从request inputStream的内容只允许读取一次，需要把request里面的内容缓存起来把
                requestWrapper = new BodyReaderHttpServletRequestWrapper(req);
                String json = HttpHelper.getBodyString(requestWrapper);
//				//判断请求参数值是否合法
                if(json!=null && json.contains("REQUEST_ERROR")){//判断inputStream内容的加密数据是否解密成功,解密不成功
                    illeagalStatus = true;
                }else{
                    try{
                        JSONObject jsonObject = JSONObject.parseObject(json);
                        if(jsonObject != null){
                            illeagalStatus = isIlleagalStatus(jsonObject, jsonObject.keySet().iterator(), illeagalStatus);
                        }
                    } catch (Exception ex) {
                        logger.error("inputStream内容转换JSON对象失败",ex);
                        //ex.printStackTrace();
                    }
                }
            }

            //对url进行判断,是否存在非法的字符串请求
            for (int i = 0; i < illegalChars.length; i++) {
                illegalChar = illegalChars[i];
                if (tempURL.indexOf(illegalChar) != -1) {
                    //System.out.println(tempURL);
                    //System.out.println("illegalChar:"+illegalChar);
                    illeagalStatus = true;
                    break;
                }
            }
        //}
        if (illeagalStatus) {
            res.setStatus(406);
            res.setContentType("application/json;chartset=" + encoding);
            res.setCharacterEncoding(encoding);
            ResponseResult responseResult = new ResponseResult().failure("当前链接存在非法字符");
            res.getWriter().print(JSON.toJSONString(responseResult));
        } else {//
            if (requestWrapper==null) {
                filterChain.doFilter(request, response);
            }else{
                filterChain.doFilter(requestWrapper, response);
            }

        }
    }

    /**
     * 判断文件上传请求的相关参数值是否合法
     *
     * @param formfields
     * @param illeagalStatus
     * @return
     */
    private boolean isIlleagalStatus(Map<String, String> formfields, boolean illeagalStatus) {
        //String illegalChar;//对参数名与参数进行判断
        f1:
        for (String paramName : formfields.keySet()) {
            String paramValue = formfields.get(paramName);
            illeagalStatus = isIlleagalStatus(illeagalStatus, paramValue);
            if (illeagalStatus) {
                break f1;
            }
        }
        return illeagalStatus;
    }

    /**
     * 判断参数值是否合法
     *
     * @param illeagalStatus
     * @param paramValue
     * @return
     */
    private boolean isIlleagalStatus(boolean illeagalStatus, String paramValue) {
        String illegalChar;
        f2:
        for (int j = 0; j < illegalChars.length; j++) {
            illegalChar = illegalChars[j];
            if (!StringUtils.isEmpty(paramValue) && paramValue.indexOf("[\"") == -1  && paramValue.indexOf(illegalChar) != -1) {
                System.out.println("illegalChar:" + illegalChar + "!paramValue:" + paramValue);
                illeagalStatus = true;
                break f2;
            }
        }
        return illeagalStatus;
    }

    /**
     * 判断http一般请求的参数是否合法
     *
     * @param jsonObject
     * @param params
     * @param illeagalStatus
     * @return
     */
    private boolean isIlleagalStatus(JSONObject jsonObject, Iterator params, boolean illeagalStatus) {
        boolean executable;
        //String illegalChar;//对参数名与参数进行判断
        w:
        while (params.hasNext()) {
            String paramName = (String) params.next();
            executable = true;
            //密码不过滤
            if (paramName.toLowerCase().contains("password") || paramName.toLowerCase().contains("ciphertext")) {
                executable = false;
            } else {
                f:for (int i = 0; i < legalNames.length; i++) {
                    if (legalNames[i].equals(paramName)) {
                        executable = false;
                        break f;
                    }
                }
            }

            if (executable) {
                String paramValue = jsonObject.getString(paramName);
                illeagalStatus = isIlleagalStatus(illeagalStatus, paramValue);
                if (illeagalStatus) {
                    System.out.println("paramName:" + paramName);
                }
            }

            if (illeagalStatus) {
                break w;
            }
        }
        return illeagalStatus;
    }
}
