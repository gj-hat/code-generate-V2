package com.jiaguo.codegenerategraduation.config.multipart;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/6 22:59
 * @description：配置MultipartConfigElement
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class MultipartConfig {

    /**
     * 配置文件上传大小
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小 10M
        factory.setMaxFileSize(DataSize.ofMegabytes(10));
        /// 总上传数据大小 10M
        factory.setMaxRequestSize(DataSize.ofMegabytes(10));
        return factory.createMultipartConfig();
    }

}