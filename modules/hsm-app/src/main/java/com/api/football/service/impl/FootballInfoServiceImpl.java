package com.api.football.service.impl;


import com.api.em.RestUrlEnum;
import com.api.football.service.IFootballInfoService;
import com.api.football.task.IFootballTask;
import com.api.restapi.service.RestService;
import com.api.vo.FoolballTeam;
import com.api.vo.FootballMatchEvent;
import com.framework.core.model.RestTypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service("footballInfoService")
public class FootballInfoServiceImpl implements IFootballInfoService {
    @Autowired
    RestService restService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    IFootballTask footballTask;

    /**
     * 先从缓存中取，没有再直接调用远程api接口
     */
    public FootballMatchEvent listMatchEvent() throws Exception {
        Object teams = redisTemplate.opsForValue().get("scheduledMatchEvent");
        if (ObjectUtils.isEmpty(teams)) {
            footballTask.scheduledMatchEvent();
            teams = redisTemplate.opsForValue().get("scheduledMatchEvent");
        }

        return (FootballMatchEvent) teams;
    }

    /**
     * 这个数据有点多，是否考虑分页？
     * 先从缓存中取，没有再直接调用远程api接口
     */
    public List<FoolballTeam> listTeam() throws Exception {
        Object teams = redisTemplate.opsForValue().get("scheduledTeam");
        if (ObjectUtils.isEmpty(teams)) {
            footballTask.scheduledTeam();
            teams = redisTemplate.opsForValue().get("scheduledTeam");
        }

        return (List<FoolballTeam>) teams;
    }

}
