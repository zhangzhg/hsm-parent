package com.hsm.api.football.service;

import com.hsm.api.vo.FoolballTeam;
import com.hsm.api.vo.FootballMatchEvent;
import com.hsm.api.vo.FootballMatchSporttery;

import java.util.List;

public interface IFootballInfoService {
    FootballMatchEvent listMatchEvent() throws Exception;

    List<FoolballTeam> listTeam() throws Exception;

    List<FootballMatchSporttery> listMatchSporttery() throws Exception;

    List<String> listMatchIdsDelete() throws Exception;
}
