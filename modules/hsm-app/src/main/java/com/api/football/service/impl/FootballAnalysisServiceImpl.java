package com.api.football.service.impl;

import com.api.cache.GuavaCache;
import com.api.cache.Loadable;
import com.api.em.RestUrlEnum;
import com.api.football.service.IFootballAnalysisService;
import com.api.restapi.service.RestService;
import com.api.vo.FootballMatchDetail;
import com.api.vo.FootballMatchHistory;
import com.api.vo.FootballMatchIntelligence;
import com.api.vo.FootballMatchLineup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service("footballAnalysisService")
public class FootballAnalysisServiceImpl implements IFootballAnalysisService {
    @Autowired
    RestService restService;


    /**
     * @param id 赛事编号
     *  1、用内存缓存能够保证每次取得数据都是最新的
     *  2、比较实时的数据，主动去取得可以用内存缓存。
     *  3、定时更新的用redis缓存
     */
    @Override
    public FootballMatchDetail getMatchDetail(String id) throws Exception {
        //更新数据方法
        Loadable<FootballMatchDetail> reLoader = args -> {
            Map<String, String> params = new HashMap<>();
            params.put("id", (String) args[0]);
            ResponseEntity<FootballMatchDetail> detail = restService.getObject(
                    RestUrlEnum.FOOTBALL_MATCH_DETAIL,
                    FootballMatchDetail.class,
                    params);

            return detail.getBody();
        };

        //从内存缓存中取。 有的话直接取， 没有的话取远程取（多个线程只有一个会去取，防止阻塞）
        return GuavaCache.getCacheLoader(RestUrlEnum.FOOTBALL_MATCH_DETAIL, id, reLoader , id);
    }

    /**
     * 足球比赛阵容
     * @param home 主队编号
     * @param away 客队编号
     */
    @Override
    public FootballMatchLineup listMatchLineup(final String home, final String away) throws ExecutionException {
        Loadable<FootballMatchLineup> reLoader = args -> {
            Map<String, String> params = new HashMap<>();
            params.put("home", (String) args[0]);
            params.put("away", (String) args[1]);
            ResponseEntity<FootballMatchLineup> lineup = restService.getObject(
                    RestUrlEnum.FOOTBALL_MATCH_LINEUP,
                    FootballMatchLineup.class,
                    params);

            return lineup.getBody();
        };

        String key = home.concat(",").concat(away);
        //从内存缓存中取。 有的话直接取， 没有的话取远程取（多个线程只有一个会去取，防止阻塞）
        return GuavaCache.getCacheLoader(RestUrlEnum.FOOTBALL_MATCH_LINEUP, key, reLoader , home, away);
    }

    /**
     * 足球历史数据
     * @param id 比赛id
     */
    @Override
    public FootballMatchHistory listMatchHistory(String id) throws ExecutionException {
        //更新数据方法
        Loadable<FootballMatchHistory> reLoader = args -> {
            Map<String, String> params = new HashMap<>();
            params.put("id", (String) args[0]);
            ResponseEntity<FootballMatchHistory> detail = restService.getObject(
                    RestUrlEnum.FOOTBALL_MATCH_HISTORY,
                    FootballMatchHistory.class,
                    params);

            return detail.getBody();
        };

        //从内存缓存中取。 有的话直接取， 没有的话取远程取（多个线程只有一个会去取，防止阻塞）
        return GuavaCache.getCacheLoader(RestUrlEnum.FOOTBALL_MATCH_HISTORY, id, reLoader , id);
    }


    /**
     * 足球比赛情报
     * @param id 比赛id
     */
    @Override
    public FootballMatchIntelligence listMatchIntelligence(String id) throws ExecutionException {
        //更新数据方法
        Loadable<FootballMatchIntelligence> reLoader = args -> {
            Map<String, String> params = new HashMap<>();
            params.put("id", (String) args[0]);
            ResponseEntity<FootballMatchIntelligence> detail = restService.getObject(
                    RestUrlEnum.FOOTBALL_MATCH_INTELLIGENCE,
                    FootballMatchIntelligence.class,
                    params);

            return detail.getBody();
        };

        //从内存缓存中取。 有的话直接取， 没有的话取远程取（多个线程只有一个会去取，防止阻塞）
        return GuavaCache.getCacheLoader(RestUrlEnum.FOOTBALL_MATCH_INTELLIGENCE, id, reLoader , id);
    }

}
