package com.hsm.api.football.controller;

import com.hsm.api.em.ApiJsonResult;
import com.hsm.api.em.ApiJsonResultEnum;
import com.hsm.api.football.service.IFootballAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * info：赛事数据分析相关
 */
@Controller
@RequestMapping("/football/analysis")
public class FootballAnalysisController {
    @Autowired
    IFootballAnalysisService footballAnalysisService;

    @RequestMapping(value="detail", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ApiJsonResult listMatchDetail(@RequestParam String id) throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballAnalysisService.getMatchDetail(id));
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }

    @RequestMapping(value="lineup", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ApiJsonResult listMatchLineup(@RequestParam String home, @RequestParam String away) throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballAnalysisService.listMatchLineup(home, away));
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }


    @RequestMapping(value="history", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ApiJsonResult listMatchHistory(@RequestParam String id) throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballAnalysisService.listMatchHistory(id));
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }

    @RequestMapping(value="intelligence", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ApiJsonResult listMatchIntelligence(@RequestParam String id) throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballAnalysisService.listMatchIntelligence(id));
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }
}
