/*******************************************************************************
 * Project Key : CPPII
 * Create on 2015-10-21 下午4:50:39
 * Copyright (c) 2008 - 2011.深圳市商联商用科技有限公司版权所有. 粤ICP备08118666号
 * 注意：本内容仅限于深圳市商联商用科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ******************************************************************************/
package com.dft.utils;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user slsy 2015-10-21 下午4:50:39
 * @author 赵晓林
 */
public class Password {

	/**
	 * 加密后的密码
	 */
	private String password;

	/**
	 * 加密使用的盐值
	 */
	private String salt;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Password [password=*** salt=** ]";
	}
}
