package com.jiaguo.codegenerategraduation.config;

import com.jiaguo.codegenerategraduation.web.mapper.SysParamsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;


@Component
public class InitParameter {
    public static Map<String, String> paramsMap = new HashMap<String, String>();

    @Autowired
    private SysParamsMapper sysParamsMapper;

    @PostConstruct
    public void init() {
        sysParamsMapper.pageQuery(null).forEach(sysParamsVo -> {
            paramsMap.put(sysParamsVo.getKey(), sysParamsVo.getValue());
        });
    }

    @PreDestroy
    public void destroy() {
        //系统运行结束
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void testOne() {
        init();
    }
}
