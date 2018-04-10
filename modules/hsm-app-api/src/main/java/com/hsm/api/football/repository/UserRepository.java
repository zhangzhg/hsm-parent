package com.hsm.api.football.repository;


import com.hsm.api.model.User;
import com.framework.core.repository.BaseJpaRepository;

public interface UserRepository extends BaseJpaRepository<User, String> {
    User getByPhoneAndStatus(String phone, Integer status);
}
