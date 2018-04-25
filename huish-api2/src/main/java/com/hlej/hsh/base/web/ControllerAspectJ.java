package com.hlej.hsh.base.web;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.hlej.hsh.base.web.model.LoginUserInfo;

@Component
@Aspect
public class ControllerAspectJ {

	private static Logger logger = LoggerFactory.getLogger(ControllerAspectJ.class);

	private void setBusinessParamValue(ProceedingJoinPoint point){
		Object[] args = point.getArgs();
		// 对一些系统 中不会初始化的参数进行实例化
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof LoginUserInfo) {
				LoginUserInfo loginUserInfo = new LoginUserInfo();
				loginUserInfo.setPhoneNumber("13825247447");
				loginUserInfo.setUserName("cuiyi");
				args[i] = loginUserInfo;
			}
		}
		
		
		
		/**
		 * 按注解进行初始化
		 */
//		Signature signature = point.getSignature();
//	    MethodSignature methodSignature = (MethodSignature)signature;
//	    Method method = methodSignature.getMethod();
//	    
//	    Annotation[] annotations = method.getDeclaredAnnotations();
//方法注解
//	    for(Annotation annotation : annotations){
//	        if(annotation instanceof MyAnnotation){
//	            MyAnnotation myAnnotation = (MyAnnotation) annotation;
//	            System.out.println("name: " + myAnnotation.name());
//	            System.out.println("value: " + myAnnotation.value());
//	        }
//	    }
	    
	    
//	    Annotation annotation = method.getAnnotation(MyAnnotation.class);
//
//	    if(annotation instanceof MyAnnotation){
//	        MyAnnotation myAnnotation = (MyAnnotation) annotation;
//	        System.out.println("name: " + myAnnotation.name());
//	        System.out.println("value: " + myAnnotation.value());
//	    }
	    
//	    Annotation[][] parameterAnnotations = method.getParameterAnnotations();
//	    Class[] parameterTypes = method.getParameterTypes();
//
//	    int i=0;
//	    for(Annotation[] annotations : parameterAnnotations){
//	      Class parameterType = parameterTypes[i++];
//
//	      for(Annotation annotation : annotations){
//	        if(annotation instanceof MyAnnotation){
//	            MyAnnotation myAnnotation = (MyAnnotation) annotation;
//	            System.out.println("param: " + parameterType.getName());
//	            System.out.println("name : " + myAnnotation.name());
//	            System.out.println("value: " + myAnnotation.value());
//	        }
//	      }
//	    }
	}
	
	
	@Around("@annotation(requestMapping)")
	public Object recordRequestLog(ProceedingJoinPoint point, RequestMapping requestMapping) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		logger.debug("Start requst :" + request.getRequestURI() + " ,Remote address:" + request.getRemoteAddr());
	
		
		setBusinessParamValue(point);
		
	    
		
		Object[] args = point.getArgs();
		// 打印输入参数
		if (logger.isDebugEnabled() && args != null) {
			String paramStr = JSON.toJSONString(args);
			if (paramStr.length() > 1000) {
				paramStr = paramStr.substring(0, 500) + "......."
						+ paramStr.substring(paramStr.length() - 500, paramStr.length());
			}

			logger.debug("Requst Param :" + paramStr);
		} else {
			logger.debug("Requst Param : Nothing...");
		}
		
		
		// 打印输出参数 与时间
		long start = System.currentTimeMillis();
		Object obj = point.proceed();
		if (logger.isDebugEnabled() && obj != null) {
			String retStr = JSON.toJSONString(obj);
			if (retStr.length() > 1000) {
				retStr = retStr.substring(0, 500) + "......."
						+ retStr.substring(retStr.length() - 500, retStr.length());
			}

			logger.debug("Response Object :" + retStr);
		} else {
			logger.debug("Response Object :Nothing...");
		}

		long end = System.currentTimeMillis();
		logger.debug("End requst :" + request.getRequestURI() + " ,Cost:" + (end - start) + "ms");
		return obj;
	}

	public static void main(String[] args) {
	}
}
