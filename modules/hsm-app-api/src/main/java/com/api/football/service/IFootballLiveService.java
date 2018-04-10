package com.api.football.service;

import com.api.dto.FootballDto;

import java.util.List;

public interface IFootballLiveService {
    /**
     * 查询比赛比分
     */
    String listScore() throws Exception;

    String listOdd() throws Exception;
}
