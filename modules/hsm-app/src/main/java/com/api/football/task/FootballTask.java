package com.api.football.task;

import com.api.em.RestUrlEnum;
import com.api.restapi.service.IRestService;
import com.api.vo.FoolballTeam;
import com.api.vo.FootballMatchEvent;
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
        redisTemplate.opsForValue().set("scheduledMatchEvent", event);
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
        redisTemplate.opsForValue().set("scheduledTeam", list);
    }
}
