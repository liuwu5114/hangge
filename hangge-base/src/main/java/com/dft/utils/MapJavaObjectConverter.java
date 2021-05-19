/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-10-11 下午1:38:24
 * Copyright (c) 2008 - 2011.深圳市腾云在线科技控股有限公司版权所有. 
 * 注意：本内容仅限于深圳市腾云在线科技控股有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.dft.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>TODO</P>
 * 
 * @version 1.0
 * @author 林仙龙（15361632946） 2013-12-20 上午11:42:59
 */
public abstract class MapJavaObjectConverter {

	private static String convertToJavaObjectError = "map 转换成 java object错误！";
	private static String convertToMapError = "java object  转换成 错误！map";
	private static String classStr = "class";
	private final static Logger logger = LoggerFactory.getLogger(MapJavaObjectConverter.class);

	/**
	 * 
	 * <p>TODO</p>
	 * 
	 * @param javaObjectType
	 * @param map
	 * @return
	 * @author 林仙龙（15361632946） 2013-12-20 上午11:43:24
	 */
	public static <T> T mapToObject(final Class<T> javaObjectType, final Map<String, Object> map) {
		T javaObject = null;
		try {
			final BeanInfo beanInfo = Introspector.getBeanInfo(javaObjectType);
			// 获取类属性 　
			javaObject = javaObjectType.newInstance();
			for (final PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
				final String propertyName = descriptor.getName();
				if (classStr.equals(propertyName)) {
					continue;
				}
				if (map.containsKey(propertyName)) {
					final Object value = map.get(propertyName);
					if (value == null) {
						continue;
					}
					if (Integer.class == descriptor.getPropertyType()) {
						if(null != value && !"".equals(value))
						   descriptor.getWriteMethod().invoke(javaObject, new Integer(String.valueOf(value)));
					} else if (BigDecimal.class == descriptor.getPropertyType()) {
						if(null != value && !"".equals(value))
						descriptor.getWriteMethod().invoke(javaObject, new BigDecimal((String) value));
					} else if (Long.class == descriptor.getPropertyType()) {
						if(null != value && !"".equals(value))
						descriptor.getWriteMethod().invoke(javaObject, new Long((String) value));
					} else if (Double.class == descriptor.getPropertyType()) {
						if(null != value || !"".equals(value))
						descriptor.getWriteMethod().invoke(javaObject, new Double((String) value));
					} else if (Float.class == descriptor.getPropertyType()) {
						if(null != value || !"".equals(value))
						descriptor.getWriteMethod().invoke(javaObject, new Float((String) value));
					} else if (Boolean.class == descriptor.getPropertyType()) {
						if(null != value || !"".equals(value))
						  descriptor.getWriteMethod().invoke(javaObject, new Boolean((String) value));
					} else {
						descriptor.getWriteMethod().invoke(javaObject, value);
					}
				}
			}
		} catch (final IntrospectionException e) {
			logger.error(convertToJavaObjectError, e);
		} catch (final IllegalArgumentException e) {
			logger.error(convertToJavaObjectError, e);
		} catch (final IllegalAccessException e) {
			logger.error(convertToJavaObjectError, e);
		} catch (final InvocationTargetException e) {
			logger.error(convertToJavaObjectError, e);
		} catch (final InstantiationException e) {
			logger.error(convertToJavaObjectError, e);
		}
		return javaObject;
	}

	/**
	 * 
	 * <p>Java object to Map 转换</p>
	 * 
	 * @param o
	 * @return
	 * @author 林仙龙（15361632946） 2013-12-20 上午11:43:38
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> objectToMap(final Object o) {
		try {
			final Map<String, Object> beanMap = BeanUtils.describe(o);
			beanMap.remove(classStr);
			return beanMap;
		} catch (final IllegalAccessException e) {
			logger.error(convertToMapError, e);
		} catch (final InvocationTargetException e) {
			logger.error(convertToMapError, e);
		} catch (final NoSuchMethodException e) {
			logger.error(convertToMapError, e);
		}
		return null;
	}

	/**
	 * 
	 * <p>object to map</p>
	 * 
	 * @param o
	 * @param isIgnoreBlankOrNull :忽略null及空字符串 转换成map
	 * @return
	 * @author 林仙龙（15361632946） 2014-5-20 上午10:16:50
	 */
	public static Map<String, Object> objectToMap(final Object o, boolean isIgnoreBlankOrNull) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass());
			for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
				String name = descriptor.getName();
				if (classStr.equals(name))
					continue;
				Object obj = descriptor.getReadMethod().invoke(o);
				if (isIgnoreBlankOrNull
						&& (obj == null || (obj instanceof String && StringUtils.isBlank((String) obj)))) {

				} else {
					map.put(name, obj);
				}
			}
			return map;
		} catch (IntrospectionException e) {
			logger.error(convertToMapError, e);
		} catch (IllegalArgumentException e) {
			logger.error(convertToMapError, e);
		} catch (IllegalAccessException e) {
			logger.error(convertToMapError, e);
		} catch (InvocationTargetException e) {
			logger.error(convertToMapError, e);
		}
		return null;
	}

	/**
	 * 
	 * <p>Java object to Map<String,String> 转换</p>
	 * 
	 * @param o
	 * @return
	 * @author 林仙龙（15361632946） 2014-12-17 下午6:49:52
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> objectToMapString(final Object o) {
		try {
			final Map<String, String> beanMap = BeanUtils.describe(o);
			beanMap.remove(classStr);
			return beanMap;
		} catch (final IllegalAccessException e) {
			logger.error(convertToMapError, e);
		} catch (final InvocationTargetException e) {
			logger.error(convertToMapError, e);
		} catch (final NoSuchMethodException e) {
			logger.error(convertToMapError, e);
		}
		return null;
	}

	/**
	 * 对请求参数排序，并按照接口规范中所述"参数名=参数值"的模式用"&"字符拼接成字符串
	 * 
	 * @param params 需要排序并参与字符拼接的参数
	 * @return 拼接后字符串
	 */
	public static String mapStringKeySortToLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		StringBuilder sb = new StringBuilder();
		int size = keys.size();
		for (int i = 0; i < size; i++) {
			String key = keys.get(i);
			Object obj = params.get(key);
			String value = String.valueOf(obj == null ? "" : obj);
			sb.append(key).append("=").append(value);
			// 最后一组参数,结尾不包括'&'
			if (i < size - 1) {
				sb.append("&");
			}
		}
		return sb.toString();
	}

	/**
	 * 对请求参数排序，并按照接口规范中所述"参数名=参数值"的模式用"&"字符拼接成字符串
	 * 
	 * @param params 需要排序并参与字符拼接的参数
	 * @return 拼接后字符串
	 */
	public static String mapObjectKeySortToLinkString(Map<String, Object> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		StringBuilder sb = new StringBuilder();
		int size = keys.size();
		for (int i = 0; i < size; i++) {
			String key = keys.get(i);
			Object obj = params.get(key);
			String value = String.valueOf(obj == null ? "" : obj);
			sb.append(key).append("=").append(value);
			// 最后一组参数,结尾不包括'&'
			if (i < size - 1) {
				sb.append("&");
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * <p>对Map的空值转成空字符串</p>
	 * 
	 * @param params
	 * @return
	 * @author 林仙龙（15361632946） 2015-4-3 上午9:20:13
	 */
	public static Map<String, Object> mapObjectValueNullToEmptyStr(Map<String, Object> params) {
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String mapKey = entry.getKey();
			String mapValue = entry.getValue() == null ? "" : String.valueOf(entry.getValue());
			params.put(mapKey, mapValue);
		}

		return params;
	}

	/**
	 * 
	 * <p>对Map的空值转成空字符串</p>
	 * 
	 * @param params
	 * @return
	 * @author 林仙龙（15361632946） 2015-4-3 上午9:19:34
	 */
	public static Map<String, String> mapStringValueNullToEmptyStr(Map<String, String> params) {
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String mapKey = entry.getKey();
			String mapValue = entry.getValue() == null ? "" : entry.getValue();
			params.put(mapKey, mapValue);
		}

		return params;
	}
	
	
	 /**
     * 移除map的空key
     *
     * @param map
     * @return
     */
    public static void removeNullKey(Map map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object obj = iterator.next();
            remove(obj, iterator);
        }
    }

    /**
     * 移除map中的value空值
     *
     * @param map
     * @return
     */
    public static Map<String, Object> removeNullValue(Map map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object obj = iterator.next();
            Object value = map.get(obj);
            remove(value, iterator);
        }
		return map;
    }

    /**
     * 移除map中的空值
     *
     * Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。
     * Iterator 被创建之后会建立一个指向原来对象的单链索引表，当原来的对象数量发生变化时，这个索引表的内容不会同步改变，
     * 所以当索引指针往后移动的时候就找不到要迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出 java.util.ConcurrentModificationException 异常。
     * 所以 Iterator 在工作的时候是不允许被迭代的对象被改变的。
     * 可以使用 Iterator 本身的方法 remove() 来删除对象， Iterator.remove() 方法会在删除当前迭代对象的同时维护索引的一致性。
     *
     * @param obj
     * @param iterator
     */
    private static void remove(Object obj, Iterator iterator) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (StringUtils.isBlank(str)) {
                iterator.remove();
            }

        } else if (obj instanceof Collection) {
            Collection col = (Collection) obj;
            if (col == null || col.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Map) {
            Map temp = (Map) obj;
            if (temp == null || temp.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            if (array == null || array.length <= 0) {
                iterator.remove();
            }
        } else {
            if (obj == null) {
                iterator.remove();
            }
        }
    }
}
