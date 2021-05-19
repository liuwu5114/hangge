/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-10-11 下午1:38:24
 * Copyright (c) 2008 - 2011.深圳市腾云在线科技控股有限公司版权所有. 
 * 注意：本内容仅限于深圳市腾云在线科技控股有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.dft.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;

/**
 * <P>Json格式解析工具类</P>
 * 
 * @version 1.0
 * @author 林仙龙（15361632946） 2013-10-11 下午1:38:24
 */
public class JsonParser {

	private JsonParser() {
	}

	private final static Logger logger = LoggerFactory.getLogger(JsonParser.class);

	/**
	 * 
	 * <p>json 文件生成类</p>
	 * 
	 * @param jsonContent 待生成的内容
	 * @param fileFullPath json文件路径
	 * @throws Exception
	 * @author 林仙龙（15361632946） 2013-10-11 下午1:39:42
	 */
	public static void generateFile(final StringBuilder jsonContent, final String fileFullPath) throws Exception {
		final File file = new File(fileFullPath);
		file.createNewFile();
		logger.info("正在生成文件....:" + file.getAbsolutePath());
		FileUtils.writeStringToFile(file, jsonContent.toString(), "UTF-8", false);
	}

	/**
	 * 
	 * <p></p>
	 * 
	 * @param jsonDetailsResult 生成结果
	 * @param fileFullPath 待读取的json文件
	 * @param encoding 改文件的编码
	 * @param class1 要转换成java对象的类型
	 * @throws Exception
	 * @author 林仙龙（15361632946） 2013-10-11 下午1:39:42
	 */
	public static <T> void parserJsonBatchFile(final List<T> jsonDetailsResult, final String fileFullPath,
			final String encoding, final Class<T> cls) throws Exception {
		Assert.notNull(jsonDetailsResult);
		final File file = new File(fileFullPath);
		if (!file.exists()) {
			throw new Exception(String.format("文件:[%s]不存在！", fileFullPath));
		}
		final List<String> jsonDetails = FileUtils.readLines(file, encoding);
		for (final String jsonDetail : jsonDetails) {
			if ("".equals(jsonDetail.trim())) {
				continue;
			}
			jsonDetailsResult.add(JSON.toJavaObject(JSON.parseObject(jsonDetail), cls));
		}
	}

	/**
	 * 
	 * <p>转换json字符串为java object</p>
	 * 
	 * @param jsonDetailsResult
	 * @param cls
	 * @return
	 * @author 林仙龙（15361632946） 2013-10-11 下午1:39:42
	 */
	public static <T> T parserJsonStringToJavaObject(final String jsonDetailsResult, final Class<T> cls) {
		return JSON.toJavaObject(JSON.parseObject(jsonDetailsResult), cls);
	}

	/**
	 * 
	 * <p>转换json字符串为java object</p>
	 * 
	 * @param jsonDetailsResult
	 * @param cls
	 * @return
	 * @author 林仙龙（15361632946） 2013-10-11 下午1:39:42
	 */
	public static <T> List<T> parserJsonStringToJavaArray(final String jsonDetailsResult, final Class<T> cls) {
		final List<T> javaOjbects = new ArrayList<T>();
		final JSONArray array = JSON.parseArray(jsonDetailsResult);
		for (int i = 0; i < array.size(); i++) {
			javaOjbects.add(JSON.toJavaObject(JSON.parseArray(jsonDetailsResult).getJSONObject(i), cls));
		}
		return javaOjbects;
	}

	/**
	 * 
	 * <p>转换java object为json 字符串</p>
	 * 
	 * @param jsonDetailsResult
	 * @param cls
	 * @return
	 * @author 林仙龙（15361632946） 2013-10-11 下午1:39:42
	 */
	public static <T> String parserJavaObjectToJsonString(final T javaObject) {
		return JSON.toJSONString(javaObject,SerializerFeature.WriteDateUseDateFormat);
	}
	
	/**
	 * 
	 * <p>转换java object为json 字符串(过滤null值属性及空值属性)</p>
	 * @param javaObject
	 * @return
	 * @author 袁修程  2019-10-30 上午11:52:14
	 */
	public static <T> String parserObjToJsonStrExcludeBlank(final T javaObject) {
		return JSON.toJSONString(MapJavaObjectConverter.objectToMap(javaObject, true),
				SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * <p>list转json</p>
	 * 
	 * @param javaList
	 * @return
	 * @author 刘武 2018-8-10 上午10:21:05
	 */
	public static <T> String parserJavaListToJsonString(final T javaList) {
		return JSONArray.toJSONString(javaList,SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 
	 * <p>TODO</p>
	 * 
	 * @param javaObject
	 * @return
	 * @author 林仙龙（15361632946） 2014-7-9 下午1:38:36
	 */
	public static <T> String parserJavaObjectToJsonString(final T javaObject, boolean isNullToEmpty) {
		if (isNullToEmpty)
			return JSON.toJSONString(javaObject, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat,
					SerializerFeature.WriteNullStringAsEmpty);
		else
			return JSON.toJSONString(javaObject,SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * <p>json字符串转map</p>
	 * 
	 * @param jsonDetailsResult json字符串
	 * @return
	 * @throws Exception
	 * @author 林仙龙 2017-3-3 下午12:26:23
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parserJsonToMap(final String jsonDetailsResult) throws Exception {
		Assert.notNull(jsonDetailsResult);
		return JSONObject.parseObject(jsonDetailsResult, Map.class);
	}

	/**
	 * <p>json字符串转map对象</p>
	 * 
	 * @param jsonDetailsResult json字符串
	 * @return
	 * @throws Exception
	 * @author 叶新东 2017-5-17 下午12:26:23
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parserJsonToMapObject(final String jsonDetailsResult) throws Exception {
		Assert.notNull(jsonDetailsResult);
		return JSONObject.parseObject(jsonDetailsResult, Map.class);
	}

	/**
	 * <p>json字符串转LinkedHashMap对象(有序map)</p>
	 * 
	 * @param jsonDetailsResult json字符串
	 * @return
	 * @throws Exception
	 * @author 叶新东 2017-12-22 下午12:26:23
	 */
	@SuppressWarnings("unchecked")
	public static LinkedHashMap<String, Object> parserJsonToLinkedHashMapObject(final String jsonDetailsResult)
			throws Exception {
		Assert.notNull(jsonDetailsResult);
		return JSONObject.parseObject(jsonDetailsResult, LinkedHashMap.class);
	}

	/**
	 * 
	 * <p>json字符串转list套map集合</p>
	 * 
	 * @param jsonDetailsResult
	 * @return
	 * @throws Exception
	 * @author 叶新东（18124509759） 2017-3-4 下午12:34:00
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> parserJsonToMapList(final String jsonDetailsResult) throws Exception {
		Assert.notNull(jsonDetailsResult);
		return JSONObject.parseObject(jsonDetailsResult, List.class);
	}
	
	public static void main(String[] args) {
		System.out.println(parserJavaObjectToJsonString(new Date(),true));;
	}
	
	/**
	 * 
	 * <p>json字符串转map<String,<String,String>>对象</p>
	 * 
	 * @param jsonDetailsResult
	 * @return
	 * @throws Exception
	 * @author 袁修程 2018-12-14 下午12:58:53
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, String>> parserJsonToMapSet(final String jsonDetailsResult) throws Exception {
		Assert.notNull(jsonDetailsResult);
		Map<String, Object> mapObj = JSONObject.parseObject(jsonDetailsResult, Map.class);
		Map<String, Map<String, String>> mapSet = Maps.newHashMap();
		for (Map.Entry<String, Object> entry : mapObj.entrySet()) {
			String string = entry.getValue().toString();
			Map<String, String> entryMap = JsonParser.parserJsonToMap(string);
			mapSet.put(entry.getKey(), entryMap);
		}
		return mapSet;
	}
	
	/**     
	 * <p>object对象转map</p>
	 *
	 * @param object
	 * @author tangzw 2021年2月25日 下午3:33:29
	 * @return
	 */
	public static Map<String, Object> parseObjectToMap(Object object) {
		return JSONObject.parseObject(JSON.toJSONString(object));
	}

}
