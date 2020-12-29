package com.example.springboot;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName zfCode
 * @Author zhaofu
 * @Date 2020/12/29
 * @Version V1.0
 * 代码自动生成器
 **/

public class zfCode {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象        
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置        
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zf");
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(false);
        // 去Service的I前缀      
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
//        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        //2、设置数据源        
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://rm-bp14f94yt54bl7l54o.mysql.rds.aliyuncs.com:3306/db_dora_syj?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8 ");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("dorabox_dba");
        dsc.setPassword("dora123456!@#$%^");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        dsc.setDbQuery(new MySqlQuery() {
            /**
             * 重写父类预留查询自定义字段<br>
             * 这里查询的 SQL 对应父类 tableFieldsSql 的查询字段，默认不能满足你的需求请重写它<br>
             * 模板中调用：  table.fields 获取所有字段信息，
             * 然后循环字段获取 field.customMap 从 MAP 中获取注入字段如下  NULL 或者 PRIVILEGES
             */
            @Override
            public String[] fieldCustom() {
                return new String[]{"NULL", "PRIVILEGES"};
            }
        });

        //3、包的配置        
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.buildClass");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        pc.setServiceImpl("Impl");
//        HashMap<String, String> map = new HashMap();
//        map.put("src/main/java/com.buildClass","VO");
//        pc.setPathInfo(map);
        mpg.setPackageInfo(pc);
        //4、策略配置        
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名  
        strategy.setInclude("tbl_business_user");
        //表名命名策略(驼峰)
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段名命名策略(驼峰)
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok；
        strategy.setEntityLombokModel(true);
        //表名前缀
        strategy.setTablePrefix("tbl_");
        // 自动填充配置
//        strategy.setLogicDeleteFieldName("deleted");        
//        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
//        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
//        ArrayList<TableFill> tableFills = new ArrayList();
//        tableFills.add(gmtCreate);
//        tableFills.add(gmtModified);
//        strategy.setTableFillList(tableFills);
        // 乐观锁        
//        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        // localhost:8080/hello_id_2    
        mpg.setStrategy(strategy);

        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //配置自定义属性注入
        mpg.setCfg(injectionConfig);

        mpg.execute(); //执行
    }
}