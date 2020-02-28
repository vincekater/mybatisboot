应用说明1.0
1.spring-boot+mybatis+mybatis plus搭建,使用swagger2用于测试control相关api
      mybatis plus在mybatis基础上，增强了功能，通过注解的方式使得javabean和数据库表映射，
        可以不使用mapper.xml文件实现CRUD，分页查询，自定义sql等功能，当然如果原来有使用mapper.xml文件还是可以继续使用
2.resources存放配置文件
2.1  application.yml配置了spring-boot测试时候的数据库连接、contextPath、log文件等信息
2.2  ssoConfig.properties配置了单点登录服务器信息
2.3  log4j.properties 配置了应用日志输出相关信息


3.java源代码说明
3.1 程序入口PlsupApplication.java 使用mybatis时候需要加入@MapperScan注解
com.szpnr.plsup.config包，里面都是使用了@Configuration注解的java类
     3.1.1 com.szpnr.plsup.config.SsoConfig单点登录配置，测试时候需要把@Configuration，不然后端请求均会拦截
     3.1.2 com.szpnr.plsup.config.WebConfig代替了原来的web.xml，用于配置web应用的相关参数
     如设置跨域请求、前后端的消息转换(前端JSON格式转java对象，后端java对象转JSON格式)等配置

3.2  com.szpnr.plsup.common包，公共类
	代码自动生成
	运行com.szpnr.plsup.common.CodeGenerator类，运行可以根据 resource\templates下的模板生产CRUD代码
	  使用方法：
           运行后在控制台输入包名，如 pbm.casereg
           输入数据表名，多个表用","号分隔，如plsup_case_regedit
           运行后将生成controller service  serviceImpl mapper entity类

3.3  前端访问的controller均要继承com.szpnr.plsup.common.controller.BaseController类,
     继承后可以使用getSession()、getHttpServletRequest()、getHttpServletResponse()等方法
     后端接受JSON格式、frommData格式的请求,JSON格式最好是要求前端进行AES加密，密钥可在HttpHelper查看
     除了文件下载,统一返回com.szpnr.plsup.common.ResponseResult的JSON字符串，格式如下
     {
        "data": {},//存放接口返回的数据,可以是某个实体表的json对象、列表、多表的组合对象等
        "meta": {
            "message": "string",//接口调用的信息，成功失败的进一步解析
            "success": true,//接口调用成功失败标志 true成功 ，false失败
            "type": "string"//接口类型设定，默认为bussess表示业务、session等
            }
     }
3.4 本项目集成了mybatis plus，查询使用了mybatis plus的查询条件构造器。具体可参考 mybatis plus查询条件构造器用法.docx
       自定义sql可参考
            com.szpnr.plsup.base.mapper.SecUsersMapper.java
            com.szpnr.plsup.base.mapper.PlsupLocationMapper.java


3.5 如果需要使用原生sql查询数据，可以使用com.szpnr.plsup.common.dao.NativeDBUtils类，或者代码生成的serverImpl中得到sqlsession。
    但不建议使用，建议使用3.4中的自定义sql。

3.6 如果有特殊需要可以使用SpringContextUtils获取ApplicationContext，通过getBean()获取bean

3.7 com.szpnr.plsup.base 跟业务耦合度较低的模块，如登录、获取菜单、验证码、附件操作、用户组织的在plsup中的编码等

3.8 com.szpnr.plsup.pbm 系统业务应用模块，按业务划分的子应用模块
     每个子应用模块有自己的controller dao model server包



