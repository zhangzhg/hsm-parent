package com.api.football.service;

import com.api.vo.FootballMatchDetail;
import com.api.vo.FootballMatchHistory;
import com.api.vo.FootballMatchIntelligence;
import com.api.vo.FootballMatchLineup;

import java.util.concurrent.ExecutionException;

public interface IFootballAnalysisService {
    FootballMatchDetail getMatchDetail(String id) throws Exception;

    FootballMatchLineup listMatchLineup(String home, String away) throws ExecutionException;

    FootballMatchHistory listMatchHistory(String id) throws ExecutionException;

    FootballMatchIntelligence listMatchIntelligence(String id) throws ExecutionException;
}
