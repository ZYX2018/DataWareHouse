package com.dwh.bi.client;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.dwh.bi.domain.BaseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
@SpringBootTest
public class ApplicationTest {


    @Test
    public  void generator(){
        FastAutoGenerator.create("jdbc:mysql://ubuntu2004.wsl:3306/dwh", "root", "root")
                .globalConfig(builder -> {
                    builder.author("zhangyx-v") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("F:\\myGithub\\DataWareHouse\\com-dwh-bi-common\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.dwh.bi") // 设置父包名
                            .entity("domain")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "F:\\myGithub\\DataWareHouse\\com-dwh-bi-common\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {//策略配置(StrategyConfig)
                    builder.enableCapitalMode()
                            .entityBuilder()
                            .enableRemoveIsPrefix()
                            .enableTableFieldAnnotation()
                            .superClass(BaseEntity.class)
                            .naming(NamingStrategy.no_change)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time").disableSerialVersionUID().addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                            .idType(IdType.AUTO).build()
                            .controllerBuilder()
                            .enableHyphenStyle()
                            .enableRestStyle().build()
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList().build();
                }).injectionConfig(builder -> { //注入配置(InjectionConfig)
                    builder.beforeOutputFile(((tableInfo, stringObjectMap) -> System.out.println("tableInfo: " + tableInfo.toString() + " objectMap: " + stringObjectMap.toString())));
            }).execute();

    }

}
