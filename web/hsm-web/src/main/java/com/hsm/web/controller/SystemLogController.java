package com.hsm.web.controller;

import com.framework.common.domain.ResultData;
import com.framework.core.util.DownLoadUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingRandomAccessFileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:增加应用日志控制台
 */
@RestController
public class SystemLogController {
    @RequestMapping(value = "/logs/health", method = RequestMethod.GET)
    public ResultData getHealthInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultData resultData  = new ResultData();
        Runtime run = Runtime.getRuntime();

        long max = run.maxMemory()/1024/1024;

        long total = run.totalMemory()/1024/1024;

        long free = run.freeMemory()/1024/1024;

        long usable = (max - total + free);

        long threadSize = Thread.getAllStackTraces().size();

        resultData.put("最大内存(m)", max);
        resultData.put("已分配内存(m)", total);
        resultData.put("已分配内存中的剩余空间(m)", free);
        resultData.put("最大可用内存(m)", usable);
        resultData.put("应用创建的线程数", threadSize);


        return  resultData;
    }
}
