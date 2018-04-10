package com.api.football.service;

import com.api.dto.FootballDto;

import java.util.List;

public interface IFootballLiveService {
    /**
     * 查询比赛比分
     */
    Object listScore() throws Exception;

    Object listOdd() throws Exception;
}
