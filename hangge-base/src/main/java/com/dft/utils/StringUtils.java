package com.dft.utils;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Maps;


/**
 * <P>字符串工具类</P>
 * 
 * @version 1.0
 * @author 林仙龙（15361632946） 2013-10-11 上午9:44:52
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	private static final Pattern pattern = Pattern.compile("\\{([\\d0-9a-zA-Z]+)\\}");
	private static final String CHARSET_NAME = "UTF-8";

	/**
	 * 转换为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		if (str != null) {
			try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 转换为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static String toString(byte[] bytes) {
		try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
	}

	/**
	 * 是否包含字符串
	 * 
	 * @param str 验证字符串
	 * @param strs 字符串组
	 * @return 包含返回true
	 */
	public static boolean inString(String str, String... strs) {
		if (str != null) {
			for (String s : strs) {
				if (str.equals(trim(s))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 替换为手机识别的HTML，去掉样式及属性，保留回车。
	 * 
	 * @param html
	 * @return
	 */
	public static String replaceMobileHtml(String html) {
		if (html == null) {
			return "";
		}
		return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
	}

	public static void main(String[] args) {
		// String splitReqString = "sgsdfgg/dfgdfgdfg/{923933544}/{DFS32DSFS}";
		// String uid = replaceByRegex("\\{([\\d0-9a-zA-Z]+)\\}", splitReqString, "fff");
		// System.out.println(uid);
		// System.out.println(formatNumber(1, "00000000"));
		System.out.println(formatUrl("{55}/{tr}/{ft}", "000", "rr", "yy"));
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return
	 * @author 赵晓林
	 */
	public static boolean isEmpty(Object obj) {
		return null == obj ? true : false;
	}

	/**
	 * 判断集合是否为空
	 * 
	 * @param c
	 * @return
	 * @author 赵晓林
	 */
	public static boolean isEmpty(Collection<?> c) {
		return null == c || c.isEmpty() ? true : false;
	}

	public static boolean isInteger(String str) {
		if (StringUtils.isBlank(str))
			return false;

		return match("^[-\\+]?[\\d]*$", str);
	}

	public static boolean isDouble(String str) {
		if (StringUtils.isBlank(str))
			return false;

		return match("^[-\\+]?[.\\d]*$", str);
	}

	/**
	 * 验证邮箱
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isEmail(String str) {
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		return match(regex, str);
	}

	/**
	 * 验证电话号码
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsTelephone(String str) {
		String regex = "^(\\d{3,4}-)?\\d{6,8}$";
		return match(regex, str);
	}

	/**
	 * 验证输入手机号码<新>
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isPhoneNumber(String str) {
		if (str == null)
			return false;
		String regex = "^(1)[0-9]{10}$";
		return match(regex, str);
	}

	/**
	 * 验证输入邮编
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isPostCode(String str) {
		if (str == null)
			return false;
		String re = "^[1-9][0-9]{5}$";
		return match(re, str);
	}

	/**
	 * 验证输入身份证号
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsIDcard(String str) {
		String regex = "(^\\d{17}(\\d{1}|x|X)$)|(^\\d{14}(\\d{1}|x|X)$)";
		return match(regex, str);
	}

	/**
	 * @param regex 正则表达式字符串
	 * @param str 要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * <p>URL 格式化</p><p>url: dd/{dd}/dfd/{ff}/{oo} , pathParams: "11", "33", "666" return
	 * dd/11/dfd/33/666</p> <p>url: dd/{dd}/dfd/{ff}/{ff} , pathParams: "11", "33", "666" return
	 * dd/11/dfd/33/33</p>
	 * 
	 * @param url
	 * @param pathParams
	 * @return
	 * @author 林仙龙（15361632946） 2016-10-9 上午8:59:14
	 */
	public static String formatUrl(String url, String... pathParams) {
		if (url.indexOf("{") != -1) {
			if (pathParams.length > 0) {
				Matcher matcher = pattern.matcher(url);
				int i = 0;
				while (matcher.find()) {
					for (int j = 0; j < pathParams.length; j++) {
						if (i == j) {
							url = url.replace(matcher.group(), pathParams[j]);
						}
					}
					i++;
				}

			} else {
				url = url.substring(0, url.indexOf("{") - 1);
			}
			return url;
		}
		return url;
	}

	/**
	 * 如果给定字符串不是以suffix结尾的，在尾部补充 suffix
	 * 
	 * @param str 字符串
	 * @param suffix 后缀
	 * @return 补充后的字符串
	 */
	public static String addSuffixIfNot(CharSequence str, CharSequence suffix) {
		if (isEmpty(str) || isEmpty(suffix)) {
			return null == str ? null : str.toString();
		}

		final String str2 = str.toString();
		final String suffix2 = suffix.toString();
		if (false == str2.endsWith(suffix2)) {
			return str2.concat(suffix2);
		}
		return str2;
	}

	/**
	 * 
	 * <p>对字符串做去除指定特殊符号处理</p>
	 * 
	 * @param str
	 * @return
	 * @author 袁修程 2019-9-19 下午1:56:38
	 */
	public static String rmAppointSepcialStr(String str) {
		if (isBlank(str))
			return null;
		Map<String, String> map = Maps.newHashMap();
		map.put("27", "半角单引号");
		map.put("22", "半角双引号");
		map.put("2019", "全角左单引号");
		map.put("2018", "全角右单引号");
		map.put("201c", "全角左双引号");
		map.put("201d", "全角右双引号");
		map.put("a0", "不间断空格");
		map.put("20", "半角空格");
		map.put("3000", "全角空格");
		map.put("0a", "换行");
		StringBuffer conversionStr = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			// 取出每一个字符
			char c = str.charAt(i);
			if (map.containsKey((Integer.toHexString(c)))) {
				continue;
			}
			conversionStr.append(c);
		}
		return conversionStr.toString();
	}
}
