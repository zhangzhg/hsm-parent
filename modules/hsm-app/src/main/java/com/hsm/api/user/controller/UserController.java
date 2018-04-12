package com.hsm.api.user.controller;

import com.framework.core.exception.BusinessException;
import com.hsm.api.dto.UserDto;
import com.hsm.api.em.ApiDicDataEnum;
import com.hsm.api.em.ApiJsonResult;
import com.hsm.api.em.ApiJsonResultEnum;
import com.hsm.api.football.service.IUserService;
import com.hsm.api.model.User;
import com.hsm.common.ICodeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "login", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ICodeMessage login(UserDto user){
        return userService.login(user);
    }

    @RequestMapping(value = "register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ICodeMessage register(User param){
        ApiJsonResult ajr=new ApiJsonResult();
        //验证手机号码和密码不为空
        if(StringUtils.isEmpty(param.getPhone())||StringUtils.isEmpty(param.getPwd())) {
            ajr.setResult(ApiJsonResultEnum.LACK_PARAM);
            return ajr;
        }

        //验证手机号， 该手机号码已经注册过
        int status = ApiDicDataEnum.REG_SUCCESS.getIntId();
        User user = userService.getByPhoneAndStatus(param.getPhone(), status);
        if(user!=null) {
            ajr.setResult(ApiJsonResultEnum.EXIST_USER);
            return ajr;
        }

        //无法开通此服务，请先联系您的店主开通权限
        status = ApiDicDataEnum.VERI_SUCCESS.getIntId();
        user = userService.getByPhoneAndStatus(param.getPhone(), status);
        if(user==null){
            ajr.setResult(ApiJsonResultEnum.SERVICE_NOT_OPEN);
            return ajr;
        }

        try {
            userService.register(user);
        } catch (BusinessException e) {
            ajr.setMsg(e.getMsg());
            return ajr;
        }
        ajr.setData(user);
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }
}
