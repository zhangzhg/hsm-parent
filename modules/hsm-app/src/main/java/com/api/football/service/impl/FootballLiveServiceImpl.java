package com.api.football.service.impl;

import com.api.common.DataHelper;
import com.api.em.RestUrlEnum;
import com.api.football.repository.mybatis.FootballDao;
import com.api.football.service.IFootballLiveService;
import com.api.football.task.IFootballTask;
import com.api.restapi.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service("footballService")
public class FootballLiveServiceImpl implements IFootballLiveService {
    @Autowired
    RestService restService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    IFootballTask footballTask;

    /**
     * 查询比赛比分（60秒内变化的数据）
     * 又2个接口，一个60秒内的数据，一个是180秒内的数据
     */
    public String listScore() throws Exception {
        Object score = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_SCORE.toString());
        if (ObjectUtils.isEmpty(score)) {
            footballTask.scheduledScore();
            score = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_SCORE.toString());
        }

        return String.valueOf(score);
    }

    @Override
    public String listOdd() throws Exception {
        Object odds = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_ODDS.toString());
        if (ObjectUtils.isEmpty(odds)) {
            footballTask.scheduledOdds();
            odds = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_ODDS.toString());
        }

        return String.valueOf(odds);
    }


}
