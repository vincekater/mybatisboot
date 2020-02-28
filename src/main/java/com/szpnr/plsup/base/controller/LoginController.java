package com.szpnr.plsup.base.controller;



import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.base.service.ISecUsersService;
import com.szpnr.plsup.common.controller.BaseController;
import com.szpnr.plsup.common.controller.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.Map;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("login")
public class LoginController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    ISecUsersService secUsersServiceImpl;

    @ApiOperation(value="用户登录", notes="用户登录")
    @RequestMapping(value="login",method = RequestMethod.POST)
    ResponseResult login(@RequestBody Map<String,String> param) throws Exception{
        String userAccount = param.get("username");
        String password = param.get("password");
//        //1.先校验验证码
//        String kaptcha = param.get("valid");
//        String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//        if (StringUtils.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
//            return new ResponseResult().failure("验证码错误");
//        }
        UserInfo userInfo = new UserInfo();
        int checkCode = secUsersServiceImpl.checkPassword(userAccount,password,userInfo);
        if (checkCode == -2) {
            if(logger.isInfoEnabled()){
                logger.info(userAccount+"该账号不存在！");
            }
           return new ResponseResult().failure("该账号不存在");
            //throw new LoginException(402, "该用户不存在", getPath());
        } else if (checkCode == -1) {
            if(logger.isInfoEnabled()){
                logger.info(userAccount+"登录账号或密码错误！");
            }
            //密码错误，需要记录登录次数
            //userLoginInfoService.saveLoginInfo(userLoginInfo, "add");
            return new ResponseResult().failure("登录账号或密码错误");
        } else {
            if(logger.isInfoEnabled()){
                logger.info("密码校验通过！");
            }
            //用户登录成功,清除登陆限制信息
            //设置cookie的过期时效
            Cookie accountC = new Cookie("userAccount", userAccount);
            accountC.setMaxAge(15 * 60 * 60);
            addCookie(accountC);
            Cookie passwordC = new Cookie("password", password);
            passwordC.setMaxAge(15 * 60 * 60);
            addCookie(passwordC);
            //UserInfo userInfo = userInfoService.getUserInfoByAccount(userAccount);
            getSession().setAttribute("userInfo", userInfo);
            getSession().setAttribute("userAccount", userAccount);
            getSession().setAttribute("loginParam", "single");

            return new ResponseResult().success(userInfo);
        }

    }


}
