package com.api.football.controller;

import com.api.em.ApiJsonResult;
import com.api.em.ApiJsonResultEnum;
import com.api.football.service.IFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.api.dto.FootballDto;

@Controller
@RequestMapping("/football")
public class FootballController {
    @Autowired
    IFootballService footballService;

    /**
     *  即时比分
     */
    @RequestMapping(value = "score", method = {RequestMethod.GET})
    @ResponseBody
    public ApiJsonResult score() {
        ApiJsonResult ajr = new ApiJsonResult();

        return ajr;
    }

}
