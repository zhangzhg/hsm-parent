package com.hsm.api.football.service.impl;


import com.hsm.api.em.RestUrlEnum;
import com.hsm.api.football.service.IFootballInfoService;
import com.hsm.api.football.task.IFootballTask;
import com.hsm.api.restapi.service.RestService;
import com.hsm.api.vo.FoolballTeam;
import com.hsm.api.vo.FootballMatchEvent;
import com.hsm.api.vo.FootballMatchSporttery;
import com.framework.core.model.RestTypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
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
        Object teams = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_EVENT.toString());
        if (ObjectUtils.isEmpty(teams)) {
            footballTask.scheduledMatchEvent();
            teams = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_EVENT.toString());
        }

        return (FootballMatchEvent) teams;
    }

    /**
     * 这个数据有点多 35526，是否考虑分页？
     * 先从缓存中取，没有再直接调用远程api接口
     */
    public List<FoolballTeam> listTeam() throws Exception {
        Object teams = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_TEAM.toString());
        if (ObjectUtils.isEmpty(teams)) {
            footballTask.scheduledTeam();
            teams = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_TEAM.toString());
        }

        return (List<FoolballTeam>) teams;
    }

    /**
     * 足球竞彩关联信息
     * 每天更新一次
     */
    @Override
    public List<FootballMatchSporttery> listMatchSporttery() throws Exception {
        Object teams = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_SPORTTERY.toString());
        if (ObjectUtils.isEmpty(teams)) {
            footballTask.scheduledMatchSporttery();
            teams = redisTemplate.opsForValue().get(RestUrlEnum.FOOTBALL_MATCH_SPORTTERY.toString());
        }

        return (List<FootballMatchSporttery>) teams;
    }

    /**
     * 24小时内删除的比赛id
     * 数据量教少，这个实时去取
     */
    @Override
    public List<String> listMatchIdsDelete() throws Exception {
        RestTypeReference<List<String>> typeRef = new RestTypeReference();
        ResponseEntity<List<String>> responseEntity = restService.getObject(
                RestUrlEnum.FOOTBALL_MATCH_IDS_DELETE,
                typeRef);

        return responseEntity.getBody();
    }

}
