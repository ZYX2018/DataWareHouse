package com.dwh.bi.client;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.dwh.bi.base.domain.BaseDomain;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
@SpringBootTest
public class ApplicationTest {


    @Test
    public  void generator(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/dwh", "root", "root")
                .globalConfig(builder -> {
                    builder.author("zhangyx-v") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("C:\\Users\\zhangyx-v\\Desktop\\today\\mybatis-plu")// 指定输出目录
                            .fileOverride().build(); // 覆盖已生成文件
                })

                //.pathInfo(Collections.singletonMap(OutputFile.xml, "F:\\myGithub\\DataWareHouse\\com-dwh-bi-common\\src\\main\\resources\\mapper"))
                .packageConfig(builder -> {
                    builder.parent("com.dwh.bi.common") // 设置父包名
                            .entity("domain").pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\Users\\zhangyx-v\\Desktop\\today\\mybatis-plu"))
                            .build(); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {//策略配置(StrategyConfig)
                    builder.enableCapitalMode()
                            .entityBuilder()
                            .enableLombok()
                            .enableRemoveIsPrefix()
                            .enableChainModel()
                            .enableActiveRecord()
                            .superClass(BaseDomain.class)
                            .enableTableFieldAnnotation()
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .addSuperEntityColumns("ID", "CREATE_TIME", "CREATE_USER", "UPDATE_TIME", "UPDATE_USER")
                            .addTableFills(new Column("CREATE_TIME", FieldFill.INSERT))
                            .addTableFills(new Property("UPDATE_TIME", FieldFill.INSERT_UPDATE))
                            .idType(IdType.ASSIGN_ID).build()
                            .controllerBuilder()
                            .enableHyphenStyle()
                            .enableRestStyle().build()
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList().build();
                }).injectionConfig(builder -> { //注入配置(InjectionConfig)
                    builder.beforeOutputFile(((tableInfo, stringObjectMap) ->
                            System.out.println("tableInfo: " + tableInfo.toString() + " objectMap: " + stringObjectMap.toString())
                            )
                    );

            }).execute();

    }

}
