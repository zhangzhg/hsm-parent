package com.hsm.api.football.task;

import com.hsm.api.em.RestUrlEnum;
import com.hsm.api.restapi.service.IRestService;
import com.hsm.api.vo.FoolballTeam;
import com.hsm.api.vo.FootballMatchEvent;
import com.hsm.api.vo.FootballMatchSporttery;
import com.framework.core.model.RestTypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class FootballTask implements IFootballTask {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    IRestService restService;

    /**
     * 此接口可以为12小时更新一次，目前api建议为24小时更新一次
     * 获取足球赛事资料
     */
    @Scheduled(cron = "0 0 4,16 * * ?")
    public void scheduledMatchEvent() throws Exception {
        RestTypeReference<HashMap> typeRef = new RestTypeReference();
        ResponseEntity<HashMap> responseEntity = restService.getObject(
                RestUrlEnum.FOOTBALL_MATCH_EVENT,
                typeRef);

        HashMap map = responseEntity.getBody();
        FootballMatchEvent event = new FootballMatchEvent();
        event.setData(map);
        redisTemplate.opsForValue().set(RestUrlEnum.FOOTBALL_MATCH_EVENT.toString(), event);
    }

    /**
     * 获取球员数据， 这个数据api建议24小时更新。
     * 设置为每日4点或者16点运行一次
     */
    @Scheduled(cron = "0 0 4,16 * * ?")
    public void scheduledTeam() throws Exception {
        RestTypeReference<List<FoolballTeam>> typeRef = new RestTypeReference();
        ResponseEntity<List<FoolballTeam>> responseEntity = restService.getObject(
                RestUrlEnum.FOOTBALL_TEAM,
                typeRef);

        List<FoolballTeam> list = responseEntity.getBody();
        redisTemplate.opsForValue().set(RestUrlEnum.FOOTBALL_TEAM.toString(), list);
    }

    @Override
    @Scheduled(cron = "0 15 0 * * ?")
    public void scheduledMatchSporttery() throws Exception {
        RestTypeReference<List<FootballMatchSporttery>> typeRef = new RestTypeReference();
        ResponseEntity<List<FootballMatchSporttery>> responseEntity = restService.getObject(
                RestUrlEnum.FOOTBALL_MATCH_SPORTTERY,
                typeRef);

        List<FootballMatchSporttery> list = responseEntity.getBody();
        redisTemplate.opsForValue().set(RestUrlEnum.FOOTBALL_MATCH_SPORTTERY.toString(), list);
    }

    @Override
    @Scheduled(cron = "0 1 0 * * ?")
    public void scheduledScore() throws Exception {
        ResponseEntity<Object> responseEntity = restService.getObject(
                RestUrlEnum.FOOTBALL_MATCH_SCORE,
                Object.class);

        Object json = responseEntity.getBody();
        redisTemplate.opsForValue().set(RestUrlEnum.FOOTBALL_MATCH_SCORE.toString(), json);
    }

    @Override
    @Scheduled(cron = "0 1 0 * * ?")
    public void scheduledOdds() throws Exception {
        ResponseEntity<Object> responseEntity = restService.getObject(
                RestUrlEnum.FOOTBALL_MATCH_ODDS,
                Object.class);

        Object json = responseEntity.getBody();
        redisTemplate.opsForValue().set(RestUrlEnum.FOOTBALL_MATCH_ODDS.toString(), json);
    }

}
