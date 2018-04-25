package com.hlej.hsh.base.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Component
@Aspect
public class ServiceAspectJ {

    private static Logger logger = LoggerFactory.getLogger(ServiceAspectJ.class);

    @Around("@within(service)")
    public Object recordServiceLog(ProceedingJoinPoint point, Service service) throws Throwable {

        logger.debug("Start invoke :" + point.getSignature().getName());

        Object[] args = point.getArgs();
        if (args != null) {
            logger.debug("Invoke Param :" + JSON.toJSONString(args));
        } else {
            logger.debug("Invoke Param : Nothing...");
        }
        long start = System.currentTimeMillis();
        Object obj = point.proceed();
        if (obj != null) {
            String retStr = JSON.toJSONString(obj);
            if (retStr.length() > 300) {
                retStr = retStr.substring(0, 100) + "......." + retStr.substring(retStr.length() - 100, retStr.length());
            }
            logger.debug("Return Object :" + retStr);
        } else {
            logger.debug("Return Object :Nothing...");
        }

        long end = System.currentTimeMillis();
        logger.debug("End invoke :" + point.getSignature().getName() + " ,Cost:" + (end - start) + "ms");
        return obj;
    }
}
