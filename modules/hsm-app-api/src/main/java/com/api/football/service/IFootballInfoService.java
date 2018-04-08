package com.api.football.service;

import com.api.vo.FoolballTeam;
import com.api.vo.FootballMatchEvent;

import java.util.List;

public interface IFootballInfoService {
    FootballMatchEvent listMatchEvent() throws Exception;

    List<FoolballTeam> listTeam() throws Exception;
}
