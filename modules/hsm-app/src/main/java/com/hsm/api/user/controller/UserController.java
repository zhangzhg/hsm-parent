package com.hsm.api.user.controller;

import com.hsm.api.common.ICodeMessage;
import com.hsm.api.dto.UserDto;
import com.hsm.api.football.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "login", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ICodeMessage login(UserDto user){
        return userService.login(user);
    }
}
