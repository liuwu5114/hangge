package com.example.service;

import com.dao.mapper.UserInfoMapper;
import com.dao.model.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo queryUserInfo(UserInfo userInfo){
        log.info("查询用户信息参数[{}]",userInfo);
        try {
            UserInfo user = userInfoMapper.queryUserInfo(userInfo);
            return user;
        }catch (Exception e){
            log.error("查询异常",e);
        }
        return null;
    };

    public List<UserInfo> queryUserList(){
        log.info("查询用户信息参数");
        try {
            List<UserInfo> list = userInfoMapper.queryUserList();
            return list;
        }catch (Exception e){
            log.error("查询异常",e);
        }
        return null;
    };

    public void saveUserInfo(UserInfo userInfo){
        try {
            userInfoMapper.insertSelective(userInfo);
        }catch (Exception e){
            log.error("添加异常",e);
        }
    };

}
