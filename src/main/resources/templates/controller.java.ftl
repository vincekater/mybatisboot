package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.szpnr.plsup.common.controller.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${entity}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
@Autowired
${table.serviceName} ${table.serviceName?uncap_first};

    @RequestMapping(value="get${entity}",method = RequestMethod.POST)
    public ResponseResult get${entity}(@RequestBody ${entity} ${entity?uncap_first}){
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        ${table.serviceName?uncap_first}.getOne(queryWrapper);
        return new ResponseResult().success(${entity?uncap_first});
    }

    @RequestMapping(value="list${entity}",method = RequestMethod.POST)
    public ResponseResult list${entity}(@RequestBody Map<String,String> param){
        Page<${entity}> page =  ${table.serviceName?uncap_first}.list(param);
        return new ResponseResult().success(page);
    }

    @RequestMapping(value="save${entity}",method = RequestMethod.POST)
    public ResponseResult save${entity}(@RequestBody ${entity} ${entity?uncap_first}){
        ${table.serviceName?uncap_first}.saveOrUpdate(${entity?uncap_first});
        return new ResponseResult().success(${entity?uncap_first});
    }

    @RequestMapping(value="deleteByID",method = RequestMethod.POST)
    public ResponseResult deleteByID(@RequestBody Map<String,String> param){
        <#list table.fields as field>
        <#if field.keyFlag>
        ${table.serviceName?uncap_first}.removeById(Long.parseLong(param.get("${field.propertyName}")));
        </#if>
        </#list>
        return new ResponseResult().success();
    }


}
</#if>
