package com.api.football.service;

import com.api.dto.FootballDto;

import java.util.List;

public interface IFootballService {
    /**
     * 查询比赛比分
     */
    List listScore(FootballDto footballDto);
}
