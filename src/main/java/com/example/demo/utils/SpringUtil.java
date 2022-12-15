package com.example.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author guoyiguang
 * @description $
 * @date 2022/9/13$
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null){

            SpringUtil.applicationContext  = applicationContext;

        }
    }

    //获取applicationContext

    public static ApplicationContext getApplicationContext() {

        return applicationContext;

    }

     //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }




}
