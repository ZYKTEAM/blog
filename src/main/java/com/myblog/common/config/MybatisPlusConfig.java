package com.myblog.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class MybatisPlusConfig {


    private static final Log log = LogFactory.getLog(MybatisPlusConfig.class);
    /**
     * 主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
     */
    private Integer idType = 1;

    /**
     * 字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
     */
    private Integer fieldStrategy = 2;

    /**
     * 驼峰下划线转换
     */
    private Boolean dbColumnUnderline = true;

    /**
     * 刷新mapper 调试神器
     */
    private Boolean isRefresh = true;

    /**
     * 数据库大写下划线转换
     */
    private Boolean isCapitalMode = true;

    /**
     * 逻辑删除配置
     */
    private String logicDeleteValue = "0";

    /**
     * 逻辑删除配置
     */
    private String logicNotDeleteValue = "1";

    @Bean(name = "globalConfig")
    public GlobalConfiguration globalConfig() {
        log.info("初始化---globalConfig");
        GlobalConfiguration globalConfiguration = new GlobalConfiguration();
        globalConfiguration.setIdType(idType);
        globalConfiguration.setDbColumnUnderline(dbColumnUnderline);
        globalConfiguration.setCapitalMode(isCapitalMode);
        globalConfiguration.setRefresh(isRefresh);
        return globalConfiguration;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "globalConfig") GlobalConfiguration globalConfiguration,
                                               @Qualifier(value = "basisDataSource") DruidDataSource dataSource) {
        log.info("初始化---sqlSessionFactory");
        String mapperLocations = "classpath*:mapping/*.xml";
        String configLocation = "mybatis-sqlconfig.xml";
        String typeAliasesPackage = "com.myblog.myblog.entity";
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        //数据源
        sqlSessionFactory.setDataSource(dataSource);
        //全局配置
        sqlSessionFactory.setGlobalConfig(globalConfiguration);
        Interceptor[] interceptors = {new PaginationInterceptor()};
        //分页插件
        sqlSessionFactory.setPlugins(interceptors);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //自动扫描mapper.xml config 别名
            sqlSessionFactory.setMapperLocations(resolver.getResources(mapperLocations));
            sqlSessionFactory.setConfigLocation(resolver.getResource(configLocation));
            sqlSessionFactory.setTypeHandlersPackage(typeAliasesPackage);
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * mabtis动态扫描
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        log.info("初始化MapperScannerConfigurer");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        String basePackage = "com.myblog.myblog.mapper";
        mapperScannerConfigurer.setBasePackage(basePackage);
        return mapperScannerConfigurer;
    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier(value = "basisDataSource") DruidDataSource dataSource) {
        log.info("DataSourceTransactionManager");
        return new DataSourceTransactionManager(dataSource);
    }
}
