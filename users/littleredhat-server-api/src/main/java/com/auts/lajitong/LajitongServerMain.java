package com.auts.lajitong;

import com.alibaba.fastjson.parser.ParserConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
//import org.springframework.web.client.RestTemplate;

/**
 *  理财师端入口.
 *  @author rongwei.huang
 */
@SpringBootApplication(scanBasePackages = { "com.auts.lajitong.**" })
@PropertySources({ @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true) })
@MapperScan("com.auts.lajitong.dao.**")
//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@EnableEurekaClient
public class LajitongServerMain {
    private static Logger logger = LogManager.getLogger(LajitongServerMain.class);

    static {
        ParserConfig.getGlobalInstance().addAccept("com.auts.lajitong.model.");
    }

//    /**
//     * rest接口.
//     * @return rest模板
//     */
//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    /**
     * 项目启动方法入口.
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(LajitongServerMain.class, args);

        logger.info("Lajitong server startup success!");
    }

}
