package com.api.football.service.impl;

import com.api.common.DataHelper;
import com.api.dto.FootballDto;
import com.api.football.repository.mybatis.FootballDao;
import com.api.football.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("footballService")
public class FootballServiceImpl implements IFootballService {
    @Autowired
    FootballDao footballDao;
    @Autowired
    DataHelper dataHelper;

    /**
     * 查询比赛比分
     */
    public List listScore(FootballDto footballDto) {

        return null;
    }
}
