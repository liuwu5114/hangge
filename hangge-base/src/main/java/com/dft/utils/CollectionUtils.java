package com.dft.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import com.google.common.collect.Maps;
import org.springframework.util.ObjectUtils;


/**
 * <P>TODO</P>
 * 
 * @version 1.0
 * @author  2013-12-31 下午2:10:38
 */
public class CollectionUtils extends org.apache.commons.collections.CollectionUtils {

	/**
	 * Return {@code true} if the supplied Map is {@code null} or empty. Otherwise, return
	 * {@code false}.
	 * 
	 * @param map the Map to check
	 * @return whether the given Map is empty
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	/**
	 * Return {@code true} if the supplied Map is {@code null} or empty. Otherwise, return
	 * {@code false}.
	 * 
	 * @param map the Map to check
	 * @return whether the given Map is empty
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !(map == null || map.isEmpty());
	}

	public static boolean isArrNotEmpty(final Object[] objArr) {
		return (null != objArr && 0 != objArr.length);
	}

	/**
	 * Merge the given Properties instance into the given Map, copying all properties (key-value
	 * pairs) over. <p>Uses {@code Properties.propertyNames()} to even catch default properties
	 * linked into the original Properties instance.
	 * 
	 * @param props the Properties instance to merge (may be {@code null})
	 * @param map the target Map to merge the properties into
	 */
	@SuppressWarnings("unchecked")
	public static void mergePropertiesIntoMap(Properties props, Map map) {
		if (map == null) {
			throw new IllegalArgumentException("Map must not be null");
		}
		if (props != null) {
			for (Enumeration en = props.propertyNames(); en.hasMoreElements();) {
				String key = (String) en.nextElement();
				Object value = props.getProperty(key);
				if (value == null) {
					// Potentially a non-String value...
					value = props.get(key);
				}
				map.put(key, value);
			}
		}
	}

	/**
	 * Check whether the given Iterator contains the given element.
	 * 
	 * @param iterator the Iterator to check
	 * @param element the element to look for
	 * @return {@code true} if found, {@code false} else
	 */
	public static boolean contains(Iterator iterator, Object element) {
		if (iterator != null) {
			while (iterator.hasNext()) {
				Object candidate = iterator.next();
				if (ObjectUtils.nullSafeEquals(candidate, element)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check whether the given Enumeration contains the given element.
	 * 
	 * @param enumeration the Enumeration to check
	 * @param element the element to look for
	 * @return {@code true} if found, {@code false} else
	 */
	public static boolean contains(Enumeration enumeration, Object element) {
		if (enumeration != null) {
			while (enumeration.hasMoreElements()) {
				Object candidate = enumeration.nextElement();
				if (ObjectUtils.nullSafeEquals(candidate, element)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return {@code true} if any element in '{@code candidates}' is contained in '{@code source}';
	 * otherwise returns {@code false}.
	 * 
	 * @param source the source Collection
	 * @param candidates the candidates to search for
	 * @return whether any of the candidates has been found
	 */
	public static boolean containsAny(Collection source, Collection candidates) {
		if (isEmpty(source) || isEmpty(candidates)) {
			return false;
		}
		for (Object candidate : candidates) {
			if (source.contains(candidate)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the first element in '{@code candidates}' that is contained in '{@code source}'. If no
	 * element in '{@code candidates}' is present in '{@code source}' returns {@code null}.
	 * Iteration order is {@link Collection} implementation specific.
	 * 
	 * @param source the source Collection
	 * @param candidates the candidates to search for
	 * @return the first present object, or {@code null} if not found
	 */
	public static Object findFirstMatch(Collection source, Collection candidates) {
		if (isEmpty(source) || isEmpty(candidates)) {
			return null;
		}
		for (Object candidate : candidates) {
			if (source.contains(candidate)) {
				return candidate;
			}
		}
		return null;
	}


	public static <T> List<Object> ListToList(List<T> list, Object o) throws Exception {

		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldArr = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			fieldArr[i] = fields[i].getName();
		}
		List<Object> objArrList = new ArrayList<Object>();
		for (T t : list) {
			Map map = Maps.newHashMap();
			for (int i = 0; i < fieldArr.length; i++) {
				Object fieldValueByName = getFieldValueByName(fieldArr[i], t);
				map.put(fieldArr[i],fieldValueByName);
			}
			objArrList.add(map);
		}
		return objArrList;
	}

	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}


}
