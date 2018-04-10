package com.hsm.api.football.service;

import com.hsm.api.vo.FootballMatchDetail;
import com.hsm.api.vo.FootballMatchHistory;
import com.hsm.api.vo.FootballMatchIntelligence;
import com.hsm.api.vo.FootballMatchLineup;

import java.util.concurrent.ExecutionException;

public interface IFootballAnalysisService {
    FootballMatchDetail getMatchDetail(String id) throws Exception;

    FootballMatchLineup listMatchLineup(String home, String away) throws ExecutionException;

    FootballMatchHistory listMatchHistory(String id) throws ExecutionException;

    FootballMatchIntelligence listMatchIntelligence(String id) throws ExecutionException;
}
