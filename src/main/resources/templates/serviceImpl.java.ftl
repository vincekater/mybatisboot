package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Map;
/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    public Page<${entity}> list(Map<String,String> param){
        int currentPage = Integer.parseInt(param.get("page"));
        int pagesize = Integer.parseInt(param.get("pagesize"));
         QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
         //queryWrapper.lambda().and(obj-> {  return obj;});
         <#list table.fields as field>
         <#if field.propertyType == "String">
         if(!StringUtils.isEmpty(param.get("${field.propertyName}"))) queryWrapper.and(obj->obj.like("${field.name}",param.get("${field.propertyName}")));//字符串类型用like处理
         </#if>
         <#if field.propertyType == "Long">
         if(!StringUtils.isEmpty(param.get("${field.propertyName}"))) queryWrapper.and(obj->obj.eq("${field.name}",param.get("${field.propertyName}")));//数字类型用相等 eq 处理
         </#if>
         <#if field.propertyType == "Timestamp" || field.propertyType == "Date" || field.propertyType == "DateTime">
         if(!StringUtils.isEmpty(param.get("${field.propertyName}"))) queryWrapper.and(obj->obj.apply("${field.name} >=to_date('{0}','yyyy-MM-dd')",param.get("${field.propertyName}")));//时间格式查询，用apply拼接sql执行函数
         </#if>
         </#list>
        <#list table.fields as field>
        <#if field.keyFlag>
        queryWrapper.orderByAsc("${field.name}");//设置排序字段，排序字段用数据库字段，默认为主键
        </#if>
        </#list>
        Page<${entity}> ipage = new Page<>(currentPage,pagesize);
        page(ipage,queryWrapper);
        return ipage;
    }
}
</#if>
