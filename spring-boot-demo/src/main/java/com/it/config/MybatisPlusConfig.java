package com.it.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.it.injectors.MySqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/11/01 19:15
 */
@Configuration
@MapperScan(basePackages = "com.it.mapper")
public class MybatisPlusConfig {


    /**
     * 自定义SQL注入器
     */
    @Bean
    public MySqlInjector mySqlInjector() {
        return new MySqlInjector();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //sql的执行分析插件
    //@Profile("prod")
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        List<ISqlParser> list = new ArrayList<>();
        list.add(new BlockAttackSqlParser());//全表更新、删除的阻断器
        sqlExplainInterceptor.setSqlParserList(list);
        return sqlExplainInterceptor;
    }

    //sql性能分析插件
    //@Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //sql的最大执行时间
        performanceInterceptor.setMaxTime(1);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    //乐观锁插件
    //更新数据，希望这条数据没有被其他更新，更新时带上版本号
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}
