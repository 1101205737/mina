package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @ClassName: SpringUtil 
 * @Description: spring处理工具类
 * @author dengbin
 * @date 2014年12月4日 上午10:20:09
 */
public class SpringUtil {

	private static ApplicationContext context;

	public static void initSpringContext()
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * 
	 * @Title: getBean 
	 * @Description: 根据bean名称获取对象
	 * @author dengbin
	 * @date 2014年12月4日 上午10:20:23 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName){
		return context.getBean(beanName);		
	}
}
