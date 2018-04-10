package com.hsm.api.user.service.impl;


import com.framework.common.util.UUIDUtils;
import com.hsm.api.common.ICodeMessage;
import com.hsm.api.dto.UserDto;
import com.hsm.api.em.ApiDicDataEnum;
import com.hsm.api.em.ApiJsonResult;
import com.hsm.api.em.ApiJsonResultEnum;
import com.hsm.api.football.repository.AppTokenRepository;
import com.hsm.api.football.repository.NickNameRepository;
import com.hsm.api.football.repository.UserRepository;
import com.hsm.api.football.service.IUserService;
import com.hsm.api.model.AppToken;
import com.hsm.api.model.NickName;
import com.hsm.api.model.User;
import com.hsm.api.vo.ApiCurrUserInfo;
import com.framework.common.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    NickNameRepository nickNameRepository;
    @Autowired
    AppTokenRepository appTokenRepository;

    /**
     * 登录api接口
     */
    @Override
    public ICodeMessage login(UserDto user) {
        ApiJsonResult ajr=new ApiJsonResult();
        if(StringUtils.isEmpty(user.getPhone())||StringUtils.isEmpty(user.getPwd())) {
            ajr.setResult(ApiJsonResultEnum.LACK_PARAM);
            return ajr;
        }

        Integer status = ApiDicDataEnum.REG_SUCCESS.getIntId();
        User userEntity = userRepository.getByPhoneAndStatus(user.getPhone(), status);

        if(userEntity==null) {
            ajr.setResult(ApiJsonResultEnum.NO_REGISTER);
            return ajr;
        }

        if(MD5Utils.encrypt(user.getPwd()).equals(userEntity.getPwd())) {
            ApiCurrUserInfo currUserInfo=new ApiCurrUserInfo();
            currUserInfo.setUserId(userEntity.getId());
            currUserInfo.setName(userEntity.getName());
            currUserInfo.setPhone(userEntity.getPhone());
            currUserInfo.setShopId(userEntity.getShipId());
            currUserInfo.setNickNameId(userEntity.getNickNameId());
            appTokenRepository.deleteByUserId(userEntity.getId());

            NickName nickName = nickNameRepository.findOne(userEntity.getNickNameId());
            nickName.setUpdateTime(new Date());
            nickNameRepository.save(nickName);

            //生成新的token
            AppToken appToken=new AppToken();
            appToken.setCreateTime(new Date());
            appToken.setRefreshTime(new Date());
            appToken.setUserId(userEntity.getId());
            appToken.setToken(UUIDUtils.generate());
            appTokenRepository.save(appToken);

            currUserInfo.setToken(appToken.getToken());
            currUserInfo.setIsBlack(userEntity.getBlack());
            ajr.setData(currUserInfo);
            ajr.setResult(ApiJsonResultEnum.SUCCESS);
            return ajr;
        }else {
            ajr.setResult(ApiJsonResultEnum.ACC_PWD_ERROR);
            return ajr;
        }
    }

    /**
     *  info:这里使用了spring redis 方法级别缓存
     *  使用说明：在同一个类中调用时无效的，因为java编译的时候会直接变成内部类
     *  原来的sessionManager.getUser 用这个来替换
     *  由于没有开启权限验证，不设置过期时间
     *  所以sessionUtils不可用
     *  （因为即使使用了，服务器或者redis重启后就没了，加上不跳转到登录页面，所以就导致取不到的情况）
     */
    @Cacheable(value = "loginUser", key = "#token")
    public User getUserByToken(String token) {
        return new User();
    }
}
