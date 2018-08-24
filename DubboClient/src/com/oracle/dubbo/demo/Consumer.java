package com.oracle.dubbo.demo;

import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.provider.DemoServiceImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {		//运行此类时，请先运行服务端的Provider
	
	public static void main(String[] args) throws Exception{

        //构建spring工厂来造demoService(consumer.xml)这个service
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        // Obtaining a remote service proxy
        
        //调用了idea中写的Dubbo_Demo项目的service接口
        DemoService demoService = (DemoService)context.getBean("demoService");
        // Executing remote methods
        String hello = demoService.sayHello("Leecole and LessonW");
        // Display the call result
        System.out.println(hello);
    }
}
