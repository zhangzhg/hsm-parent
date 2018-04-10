package com.hsm.api.football.repository;


import com.hsm.api.model.AppToken;
import com.framework.core.repository.BaseJpaRepository;

public interface AppTokenRepository extends BaseJpaRepository<AppToken, String> {
    void deleteByUserId(String id);
}
