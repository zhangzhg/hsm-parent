package com.hsm.api.user.service.impl;


import com.framework.common.util.MD5Utils;
import com.framework.common.util.UUIDUtils;
import com.framework.core.exception.BusinessException;
import com.hsm.api.common.ICodeMessage;
import com.hsm.api.dto.UserDto;
import com.hsm.api.em.ApiDicDataEnum;
import com.hsm.api.em.ApiJsonResult;
import com.hsm.api.em.ApiJsonResultEnum;
import com.hsm.api.football.repository.*;
import com.hsm.api.football.repository.mybatis.UserDao;
import com.hsm.api.football.service.IUserService;
import com.hsm.api.model.*;
import com.hsm.api.properties.HsmProperties;
import com.hsm.api.vo.ApiCurrUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    NickNameRepository nickNameRepository;
    @Autowired
    AppTokenRepository appTokenRepository;
    @Autowired
    PurseRepository purseRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    HsmProperties hsmProperties;
    @Autowired
    UserDao userDao;

    /**
     * 登录api接口
     */
    @Override
    public ICodeMessage login(UserDto param) {
        ApiJsonResult ajr=new ApiJsonResult();
        //登录手机号码不能为空
        if(StringUtils.isEmpty(param.getPhone())||StringUtils.isEmpty(param.getPwd())) {
            ajr.setResult(ApiJsonResultEnum.LACK_PARAM);
            return ajr;
        }

        Integer status = ApiDicDataEnum.REG_SUCCESS.getIntId();
        User user = userRepository.getByPhoneAndStatus(param.getPhone(), status);

        //判断手机号码是否存在，不存在直接返回
        if(user==null) {
            ajr.setResult(ApiJsonResultEnum.NO_REGISTER);
            return ajr;
        }

        //密码相同的话可以登录
        if(MD5Utils.encrypt(param.getPwd()).equals(user.getPwd())) {
            //删除掉上次登录信息
            ApiCurrUserInfo currUserInfo=new ApiCurrUserInfo();
            currUserInfo.setUserId(user.getId());
            currUserInfo.setName(user.getName());
            currUserInfo.setPhone(user.getPhone());
            currUserInfo.setShopId(user.getShipId());
            currUserInfo.setNickNameId(user.getNickNameId());
            appTokenRepository.deleteByUserId(user.getId());

            //更新登录时间
            NickName nickName = nickNameRepository.findOne(user.getNickNameId());
            nickName.setUpdateTime(new Date());
            nickNameRepository.save(nickName);

            //生成新的token，新增登录信息
            AppToken appToken=new AppToken();
            appToken.setCreateTime(new Date());
            appToken.setRefreshTime(new Date());
            appToken.setUserId(user.getId());
            appToken.setToken(UUIDUtils.generate());
            appTokenRepository.save(appToken);

            //返回登录结果
            currUserInfo.setToken(appToken.getToken());
            currUserInfo.setIsBlack(user.getBlack());
            ajr.setData(currUserInfo);
            ajr.setResult(ApiJsonResultEnum.SUCCESS);
            return ajr;
        }else {
            ajr.setResult(ApiJsonResultEnum.ACC_PWD_ERROR);
            return ajr;
        }
    }

    /**
     * 验证手机号
     */
    @Override
    public void register(User user) {
        //更新修改时间
        user.setUpdateTime(new Date());
        user.setStatus(ApiDicDataEnum.REG_SUCCESS.getIntId());
        user.setPwd(MD5Utils.encrypt(user.getPwd()));

        //取出数据库中最大的加1，作为名称
        DecimalFormat format=new DecimalFormat("yh0000000");
        int max = userDao.getMaxCountName("yh");

        NickName nickName=new NickName();
        nickName.setUserId(user.getId());
        nickName.setIsDefault(true);
        nickName.setUpdateNickCount(0);
        nickName.setBeFollow(0);
        nickName.setIsSpeciallyInvite(false);
        nickName.setContinuityWinNum(0);
        nickName.setName(format.format(max));
        nickName.setHeadPic(hsmProperties.getImg()
                .concat("default_headpic_")
                .concat(new Random().nextInt(3)+".png"));

        //设置实体店id，随便取一家
        List<Shop> shops = shopRepository.findByDeleted(false);
        if(shops!=null&&shops.size()>0){
            Shop shop = shops.get(new Random().nextInt(shops.size()));
            user.setShipId(shop.getId());
            user.setShopName(shop.getName());
            nickName.setShopId(shop.getId());
        }else {
            throw new BusinessException(ApiJsonResultEnum.NO_SHOP.getMsg());
        }

        //更新角色
        nickNameRepository.save(nickName);

        //更新用户
        user.setNickNameId(nickName.getId());
        user.setBlack(false);
        userRepository.save(user);

        //更新钱包
        Purse purseEntity=new Purse();
        purseEntity.setBonus(0d);
        purseEntity.setCreaterId(user.getId());
        purseEntity.setCreateTime(new Date());
        purseEntity.setDeleted(false);
        purseEntity.setPurse(0d);
        purseEntity.setUpdaterId(user.getId());
        purseEntity.setUpdateTime(new Date());
        purseEntity.setUserId(user.getId());
        purseRepository.save(purseEntity);
    }

    @Override
    public User getByPhoneAndStatus(String phone, Integer status) {
        return userRepository.getByPhoneAndStatus(phone, status);
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
