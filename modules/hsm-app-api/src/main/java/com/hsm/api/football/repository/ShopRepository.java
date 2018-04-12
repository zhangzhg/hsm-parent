package com.hsm.api.football.repository;

import com.framework.core.repository.BaseJpaRepository;
import com.hsm.api.model.Shop;

import java.util.List;

public interface ShopRepository extends BaseJpaRepository<Shop, String> {
    List<Shop> findByDeleted(boolean isDeleted);
}
