package com.hsm.api.football.controller;

import com.hsm.api.em.ApiJsonResult;
import com.hsm.api.em.ApiJsonResultEnum;
import com.hsm.api.football.service.IFootballLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * info: 比赛实时数据。
 * 包含所有公司的比分赔率，赛程，以及结果
 */
@Controller
@RequestMapping("/football/live")
public class FootballLiveController {
    @Autowired
    IFootballLiveService footballLiveService;

    /**
     *  即时比分
     */
    @RequestMapping(value = "score", method = {RequestMethod.GET})
    @ResponseBody
    public ApiJsonResult score() throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballLiveService.listScore());
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }

    /**
     * 足球赛程赛果
     */
    @RequestMapping(value = "odds", method = {RequestMethod.GET})
    @ResponseBody
    public ApiJsonResult odds() throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballLiveService.listOdd());
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }
}
