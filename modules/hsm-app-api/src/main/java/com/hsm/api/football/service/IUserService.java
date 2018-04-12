package com.hsm.api.football.service;

import com.hsm.api.common.ICodeMessage;
import com.hsm.api.dto.UserDto;
import com.hsm.api.model.User;

public interface IUserService {
    ICodeMessage login(UserDto user);

    void register(User user);

    User getByPhoneAndStatus(String phone, Integer status);
}
