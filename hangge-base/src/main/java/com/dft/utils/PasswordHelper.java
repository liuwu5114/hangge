package com.dft.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Assert;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;


/**
 * <P>密码加密服务</P>
 * 
 * @version $Id$
 * @user slsy 2015-10-10 下午2:26:34
 * @author 林仙龙
 */
public class PasswordHelper {

	/**
	 * <p>根据用户设置的密码获取加密后的密码以及加密使用的盐值 </p>
	 * 
	 * @param password
	 * @return
	 * @user slsy 2015-10-21 下午4:54:15
	 * @return Password
	 * @author 林仙龙 （15361632946）
	 */
	public static Password encryptPasswordByModel(String password) {
		Assert.hasText(password, "密码不能为空");
		String salt = RandomStringUtils.randomAlphanumeric(16);
		Password pwd = new Password();
		pwd.setSalt(salt);
		pwd.setPassword(Hashing.md5().hashString(password + salt, Charsets.UTF_8).toString());
		return pwd;
	}

	/**
	 * <p>密码加密</p>
	 * 
	 * @param password
	 * @return
	 * @author 林仙龙（15361632946） 2016-7-20 下午2:10:40
	 */
	public static String encryptPassword(String password) {
		Assert.hasText(password, "密码不能为空");
		byte[] salt = Digests.generateSalt(Digests.SALT_SIZE);
		byte[] hashencryptInfo = Digests.sha1(password.getBytes(), salt, Digests.HASH_INTERATIONS);
		return Encodes.encodeHex(salt) + Encodes.encodeHex(hashencryptInfo);
	}

	/**
	 * <p>密码对比</p>
	 * 
	 * @param orgEncryptInfo 原加密密码
	 * @param encryptInfo 登入密码
	 * @return
	 * @author 林仙龙（15361632946） 2016-7-20 下午2:10:29
	 */
	public static boolean checkPassword(String orgEncryptInfo, String encryptInfo) {
		Assert.hasText(orgEncryptInfo, "原密码不能为空");
		Assert.hasText(encryptInfo, "密码不能为空");
		byte[] salt = Encodes.decodeHex(orgEncryptInfo.substring(0, 16));
		byte[] hashPassword = Digests.sha1(encryptInfo.getBytes(), salt, Digests.HASH_INTERATIONS);
		String requestPassword = Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
		return orgEncryptInfo.equals(requestPassword);
	}

	/**
	 * <p>根据用户输入的密码和已有的盐值获取加密字符串 </p>
	 * 
	 * @param password
	 * @param salt
	 * @return
	 * @user slsy 2015-10-20 下午2:28:38
	 * @return String
	 * @author 林仙龙 （15361632946）
	 */
	public static String getEncryptPassword(String password, String salt) {
		Assert.hasText(password, "密码不能为空");
		Assert.hasText(salt, "盐值不能为空");
		return Hashing.md5().hashString(password + salt, Charsets.UTF_8).toString();
	}

	/**
	 * <p>校验输入的密码和指定密码的一致性</p>
	 * 
	 * @param inputPassword 用户输入的密码
	 * @param savePassword 数据库存储的hash密码值
	 * @param salt 数据库存储的盐值
	 * @return
	 * @user slsy 2015-10-26 上午11:54:50
	 * @return boolean
	 * @author 林仙龙 （15361632946）
	 */
	public static boolean checkPassword(String inputPassword, String salt, String savePassword) {
		Assert.hasText(salt, "盐值不能为空");
		Assert.hasText(savePassword, "校验密码不能为空");
		Assert.hasText(salt, "盐值不能为空");
		String inputPass = Hashing.md5().hashString(inputPassword + salt, Charsets.UTF_8).toString();
		if (inputPass.equals(savePassword)) {
			return true;
		}
		return false;
	}

	/**
	 * <p>根据用户输入的密码和已有的盐值获取加密字符串 </p>
	 * 
	 * @param password
	 * @param salt
	 * @return
	 * @user slsy 2015-10-20 下午2:28:38
	 * @return String
	 * @author 赵晓林
	 */
	public static String getEncryptPassword(String password) {
		Assert.hasText(password, "密码不能为空");
		// Assert.hasText(salt, "盐值不能为空");
		return Hashing.md5().hashString(password, Charsets.UTF_8).toString();
	}



	public static void main(String[] args) {
		System.out.println(Hashing.md5().hashString("000000", Charsets.UTF_8));


		byte[] bytes = Digests.sha1("000000".getBytes(), Digests.generateSalt(Digests.SALT_SIZE), Digests.HASH_INTERATIONS);

		String s2 = Encodes.encodeHex("000000".getBytes());
		System.out.println(s2);


		String s1 = Encodes.encodeHex(Digests.sha1("000000".getBytes(), Digests.generateSalt(Digests.SALT_SIZE), Digests.HASH_INTERATIONS));
		System.out.println(s1);

		String s = PasswordHelper.encryptPassword("000000");
		System.out.println(s);

		boolean b = checkPassword("455cf8ee1123dac71390c2269db0c48754dff993e016e06d39f588dc", "000000");
		System.out.println(b);
	}

}
