package com.hsm.api.football.service;

public interface IFootballLiveService {
    /**
     * 查询比赛比分
     */
    Object listScore() throws Exception;

    Object listOdd() throws Exception;
}
