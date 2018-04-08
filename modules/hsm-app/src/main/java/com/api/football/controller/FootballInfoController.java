package com.api.football.controller;


import com.api.em.ApiJsonResult;
import com.api.em.ApiJsonResultEnum;
import com.api.football.service.IFootballInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/football/info")
public class FootballInfoController {
    @Autowired
    IFootballInfoService footballInfoService;

    /**
     * 获取主球赛事资料
     * 此接口可以为12小时更新一次，目前api建议为24小时更新一次
     */
    @RequestMapping(value="matchevents", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ApiJsonResult listMatchEvent() throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballInfoService.listMatchEvent());
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }

    /**
     * 获取球员资料
     * 此接口可以为12小时更新一次，目前api建议为24小时更新一次
     * 数据有点多，是否需要分页处理
     */
    @RequestMapping(value="teams", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ApiJsonResult listTeam() throws Exception {
        ApiJsonResult ajr = new ApiJsonResult();
        ajr.setData(footballInfoService.listTeam());
        ajr.setResult(ApiJsonResultEnum.SUCCESS);
        return ajr;
    }
}
