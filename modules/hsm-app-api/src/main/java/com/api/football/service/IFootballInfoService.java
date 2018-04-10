package com.api.football.service;

import com.api.vo.FoolballTeam;
import com.api.vo.FootballMatchEvent;
import com.api.vo.FootballMatchSporttery;

import java.util.List;

public interface IFootballInfoService {
    FootballMatchEvent listMatchEvent() throws Exception;

    List<FoolballTeam> listTeam() throws Exception;

    List<FootballMatchSporttery> listMatchSporttery() throws Exception;

    List<String> listMatchIdsDelete() throws Exception;
}
