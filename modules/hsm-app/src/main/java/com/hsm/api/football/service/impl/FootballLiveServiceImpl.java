package com.hsm.api.football.service.impl;

import com.hsm.api.em.RestUrlEnum;
import com.hsm.api.football.service.IFootballLiveService;
import com.hsm.api.football.task.IFootballTask;
import com.hsm.api.restapi.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    public Object listScore() throws Exception {
        Object score = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_SCORE.toString());
        if (ObjectUtils.isEmpty(score)) {
            footballTask.scheduledScore();
            score = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_SCORE.toString());
        }

        return score;
    }

    @Override
    public Object listOdd() throws Exception {
        Object odds = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_ODDS.toString());
        if (ObjectUtils.isEmpty(odds)) {
            footballTask.scheduledOdds();
            odds = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_ODDS.toString());
        }

        return odds;
    }


}
