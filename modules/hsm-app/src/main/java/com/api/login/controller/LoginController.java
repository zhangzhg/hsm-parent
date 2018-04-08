package com.api.login.controller;

import com.framework.core.auth.BaseUsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String login() {
        Subject currentUser = SecurityUtils.getSubject();
        BaseUsernamePasswordToken token = new BaseUsernamePasswordToken("admin", "111");
        currentUser.login(token);
        return "hello word";
    }
}
