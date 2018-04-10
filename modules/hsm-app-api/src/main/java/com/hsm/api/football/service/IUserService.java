package com.hsm.api.football.service;

import com.hsm.api.common.ICodeMessage;
import com.hsm.api.dto.UserDto;

public interface IUserService {
    ICodeMessage login(UserDto user);
}
