package com.szpnr.plsup.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author dengsy
 * @Date 2019/07/23
 * @Description 实现WebMvcConfigurer接口，配置返回统一的JSON格式
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    public WebConfig(){

    }



//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/wwebjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/swagger/");
//
//    }



    /**
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry){
        //registry.addFormatterForFieldType();
    }

    /**
     * 设置跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("*")
                //.allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .maxAge(3600);
//        registry.addMapping("/api/**")
//                .allowedOrigins("http://domain2.com")
//                .allowedMethods("PUT", "DELETE")
//                .allowedHeaders("header1", "header2", "header3")
//                .exposedHeaders("header1", "header2")
//                .allowCredentials(false).maxAge(3600);
    }

    /**
     * 注册fastjsonConverter消息转换对象
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //定义一个Converter消息转换对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //添加fastJson的配置信息，比如是否需要格式化返回的JSON数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
        //处理中文问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastMediaTypes.add(MediaType.TEXT_PLAIN);
        fastMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        //fastMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        //Converter消息转换对象添加配置信息
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //将Converter消息转换对象添加到converters中
        converters.add(fastJsonHttpMessageConverter);
    }

//    @Bean("mappingJackson2HttpMessageConverter")
//    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter(){
//        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
//        return messageConverter;
//    }
}
