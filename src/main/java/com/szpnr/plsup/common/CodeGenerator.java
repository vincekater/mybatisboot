package com.szpnr.plsup.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("dengsy");
        globalConfig.setOpen(false);
        globalConfig.setIdType(IdType.INPUT);
        globalConfig.setDateType(DateType.ONLY_DATE);//设置日期格式转换类型为
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:oracle:thin:@192.168.110.2:1521:oraplan");
        //dsc.setSchemaName("PLATFORM");
        dataSourceConfig.setDriverName("oracle.jdbc.driver.OracleDriver");
        dataSourceConfig.setUsername("suplis");
        dataSourceConfig.setPassword("plansuplis");
        dataSourceConfig.setDbType(DbType.ORACLE);
        dataSourceConfig.setTypeConvert(new OracleTypeConvert());
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent("com.szpnr.plsup");
        autoGenerator.setPackageInfo(packageConfig);

        // 自定义配置，生成vue文件
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String vueProjectPath="E:\\ideaworkspace\\plsup2vue\\src\\components\\page";
        String vueListFilePath = "/templates/Edit.vue.ftl";
        String vueEditFilePath = "/templates/List.vue.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        // 不生成mapper.xml配置文件，使用注解方式自定义sql
        focList.add(new FileOutConfig(vueListFilePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return vueProjectPath + "/src/components/page/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "List.vue";
            }
        });
        focList.add(new FileOutConfig(vueEditFilePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return vueProjectPath + "/src/components/page/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Edit.vue";
            }
        });
        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });

        injectionConfig.setFileOutConfigList(focList);
        autoGenerator.setCfg(injectionConfig);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
         templateConfig.setEntity("templates/entity.java");
         templateConfig.setService("templates/service.java");
         templateConfig.setServiceImpl("templates/serviceImpl.java");
         templateConfig.setController("templates/controller.java");
         templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.szpnr.plsup.common.BaseEntity");

        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass("com.szpnr.plsup.common.controller.BaseController");
        strategy.setControllerMappingHyphenStyle(true);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

}