package com.clothesmake.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class ApplicationContextUtil {

    private static ApplicationContext context = null;

    private ApplicationContextUtil() {
        super();
    }

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return context.getBean(beanName, clazz);
    }

    public static <T> T getBean(Class<T> clazz) {
        T t = null;
        Map<String, T> map = context.getBeansOfType(clazz);
        for (Map.Entry<String, T> entry : map.entrySet()) {
            t = entry.getValue();
        }
        return t;
    }

    public static boolean containsBean(String beanName) {
        return context.containsBean(beanName);
    }

    public static boolean isSingleton(String beanName) {
        return context.isSingleton(beanName);
    }

    public static Class getType(String beanName) {
        return context.getType(beanName);
    }

}