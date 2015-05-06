package com.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProxyUtil {
	
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	  * getter()
	  *根据对象属性字符串调用对应的getter方法返回值
	  * @param obj 对象
	  * @param att 属性字符串
	  * @return
	  * @throws SecurityException
	  * @throws NoSuchMethodException
	  * @throws IllegalArgumentException
	  * @throws IllegalAccessException
	  * @throws InvocationTargetException
	 */
	public static Object getter(Object obj, String att) 
			throws SecurityException, NoSuchMethodException, 
			IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		try{
			Method method = obj.getClass().getMethod("get" + firstLetterToUpper(att)); 
			return method.invoke(obj); 
		}catch(Exception e){
			return null;
		}
	} 
	
	
	public static Object isser(Object obj, String att) 
			throws SecurityException, NoSuchMethodException, 
			IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		try{
			Method method = obj.getClass().getMethod("is" + firstLetterToUpper(att)); 
			return method.invoke(obj); 
		}catch(Exception e){
			return null;
		}
	} 
	/**
	 * 
	  * firstLetterToUpper()
	  *首字母大写
	  * @param str 字符串
	  * @return 
	 */
	protected static String firstLetterToUpper(String str) { 
		char[] array = str.toCharArray(); 
		array[0] -= 32; 
		return String.valueOf(array); 
	} 
	
	/**
	 * 
	 * @param obj
	 * @param att
	 * @param value
	 * @param type
	 */
	public static void setter(Object obj, String att, Object value,
			Class<?> type) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		try {
			att =firstLetterToUpper(att);
			Method method = obj.getClass().getMethod("set" + att, type);
			if (type == String.class)
				method.invoke(obj, toString(value));
			else if (type == Integer.class || type == int.class)
				method.invoke(obj, toInteger(value));
			else if (type == double.class || type == Double.class)
				method.invoke(obj, toDouble(value));
			else if (type == char.class || type == Character.class)
				method.invoke(obj, toCharacter(value));
			else if (type == long.class || type == Long.class)
				method.invoke(obj, toLong(value));
			else if (type == float.class || type == Float.class)
				method.invoke(obj, toFloat(value));
			else if (type == byte.class || type == Byte.class)
				method.invoke(obj, toByte(value));
			else if (type == boolean.class || type == Boolean.class)
				method.invoke(obj, toBoolean(value));
			else if (type == short.class || type == Short.class)
				method.invoke(obj, toShort(value));
			else if (type == java.util.Date.class) {
				method.invoke(obj, df.parse(String.valueOf(value)));
			} else if (type == java.sql.Timestamp.class) {
                method.invoke(obj ,
                        new Timestamp(
                                df.parse(String.valueOf(value)).getTime()));
            } else
				method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static String toString(Object object) {
		if (object == null) {
		    return "";}
		else if (object instanceof Date) {
			return df.format(object);
		} else if (object instanceof Timestamp) {
            return df.format(object);
        }
		else
			return object.toString();
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Integer toInteger(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0;
		else
			return Integer.parseInt(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Double toDouble(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0.0;
		else
			return Double.parseDouble(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Float toFloat(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0.0f;
		else
			return Float.parseFloat(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Long toLong(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0l;
		else
			return Long.parseLong(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Boolean toBoolean(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return true;
		else
			return Boolean.parseBoolean(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Short toShort(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0;
		else
			return Short.parseShort(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Byte toByte(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0;
		else
			return Byte.parseByte(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Character toCharacter(Object object) {
		if (object == null)
			return '\u0beb';
		else
			return (Character) object;
	}	
	
	
	/**
	 * 
	 * @Title: getFields 
	 * @Description: 根据实例获取类的字段属性 
	 * @param obj
	 * @return
	 */
	public static Field[] getFields(Object obj){
		Field[] fields = obj.getClass().getDeclaredFields();
		Field[] parent = obj.getClass().getSuperclass().getDeclaredFields();
		Field[] result = new Field[fields.length+parent.length];
		System.arraycopy(fields,0,result, 0, fields.length);
		System.arraycopy(parent,0,result, fields.length, parent.length);
		return result;
	}
	
	/**
	 * 
	 * @Title: getObject 
	 * @Description: 根据类名称字符串获取实例 
	 * @param name
	 * @return
	 */
	public static Object getObject(String name){
		try {
			return Class.forName(name).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @Title: getFields 
	 * @Description: 根据类型名称字符串获取类字段属性
	 * @param name
	 * @return
	 */
	public static Field[] getFields(String name){
		try {
			Field[] fields = Class.forName(name).getDeclaredFields();
			Field[] child = Class.forName(name).getSuperclass().getDeclaredFields();
			Field[] result = new Field[fields.length+child.length];
			System.arraycopy(fields,0,result, 0, fields.length);
			System.arraycopy(child,0,result, fields.length, child.length);
			return result;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: getFields 
	 * @Description: 获取一个calss的字段名称和字段type的对应关系
	 * @param clazz
	 * @return
	 */
	public static Map<String,Class<?>> getFields(Class<?> clazz){
		try {
			Map<String,Class<?>> map = new HashMap<String,Class<?>>();
			Field[] fields = clazz.getDeclaredFields();
			Field[] child = clazz.getSuperclass().getDeclaredFields();
			for(Field field : fields){
				map.put(field.getName(), field.getType());
			}
			for(Field field : child){
				map.put(field.getName(), field.getType());
			}
			return map;
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object invoke(String class_,String method_,Object...args) throws Exception{
		Class<?> clazz = Class.forName(class_);
		Method method = null;
		Object ret = null;
		if(args != null){
			Class<?>[] types = new Class[args.length];
			for(int i=0;i<args.length;i++){
				types[i] = args[i].getClass();
			}
			method = clazz.getMethod(method_, types);
			ret = method.invoke(null,args);
		}else{
			method = clazz.getMethod(method_);
			ret = method.invoke(null);
		}
		return ret;
	}

}