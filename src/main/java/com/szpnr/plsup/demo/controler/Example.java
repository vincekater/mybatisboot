package com.szpnr.plsup.demo.controler;

import com.szpnr.plsup.mybatis.dao.PlsupLocationMapper;
import com.szpnr.plsup.mybatis.model.PlsupLocation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("example")
public class Example {


    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String", paramType = "path")
    //@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code=200,message = "返回成功"),
            @ApiResponse(code=400,message = "参数没填好"),
            @ApiResponse(code=404,message = "请求路径不对"),
    })
    @RequestMapping(value="home/{name}",method = RequestMethod.GET)

    String home(String name) {
        PlsupLocation location = plsupLocationMapper.selectByPrimaryKey(Short.parseShort("326"));
        System.out.println(location);
        return "Hello World!";
    }

    @Autowired
    PlsupLocationMapper plsupLocationMapper;

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example.class, args);
//    }

}
