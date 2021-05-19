package com.dft.command;

/**
 * @program: hangge
 * @description:
 * @author: 刘武
 * @create: 2021-05-14 09:23
 **/
public class UserCommand {

    // 用户ID
    private Integer userId;

    // 手机号
    private String mobile;

    // 密码
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
