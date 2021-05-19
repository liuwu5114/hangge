package com.dft.controller;

import com.dft.base.BaseCotroller;
import com.dao.model.UserInfo;
import com.dft.base.WebResult;
import com.dft.command.UserCommand;
import com.dft.utils.JsonParser;
import com.dft.utils.StringUtils;
import com.example.service.TestService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("hangge")
public class LoginCotroller extends BaseCotroller {

    @Autowired
    private TestService testService;

    /**
     * 功能描述: <br>
     * 〈进入登录界面〉
     * @Param: [userInfo]
     * @Return: java.lang.String
     * @Author: 刘武
     * @Date: 2021/5/14 9:02
     */
    @GetMapping(value = "loginInput")
    public String loginInput() {
        log.info("进入登录界面");
        return "login";
    }

    /**
     * 功能描述: <br>
     * 〈用户登录〉
     * @Param: [userInfo]
     * @Return: java.lang.String
     * @Author: 刘武
     * @Date: 2021/5/14 9:03
     */
    @PostMapping(value = "login")
    public String login(UserCommand command, ModelMap map) {
        log.info("登录操作参数[{}]",command);
        try {
            UserInfo user = new UserInfo();
            user.setMobile(command.getMobile());
            UserInfo userInfo = testService.queryUserInfo(user);
            if(null == userInfo){
                log.info("用户不存在,用户手机号[{}]",command.getMobile());
                map.put("error", "用户不存在");
                return "error";
            }
            if(StringUtils.isNotEmpty(userInfo.getPassWord())){
                if(!command.getPassWord().equals(userInfo.getPassWord())){
                    log.info("密码不正确[{}]",command.getPassWord());
                    map.put("error", "密码不正确");
                    return "error";
                }
            }
            map.put("userInfo", userInfo);
        }catch (Exception e){
            log.error("登录异常",e );
        }
        return "index";
    }



    @ResponseBody
    @GetMapping(value = "queryUserInfo")
    public String queryUserInfo(Integer id) {
        log.info("测试配置log4j2日志打印[{}]",id);
        if(null == id){
            return "id为空";
        }
        UserInfo user = new UserInfo();
        user.setId(id);
        UserInfo userInfo = testService.queryUserInfo(user);
        log.info("结果集[{}]",userInfo);
        String userJson = JsonParser.parserJavaObjectToJsonString(userInfo);
        return userJson;
    }

    @ResponseBody
    @GetMapping(value = "queryUserList")
    public List<UserInfo> queryUserList() {
        log.info("测试配置log4j2日志打印");
        return testService.queryUserList();
    }

    @ResponseBody
    @GetMapping(value = "saveUserInfo")
    public void saveUserInfo(UserInfo userInfo) {
        log.info("测试配置log4j2日志打印"+userInfo);
        testService.saveUserInfo(userInfo);
    }


}
