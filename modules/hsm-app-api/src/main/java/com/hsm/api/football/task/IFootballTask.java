package com.hsm.api.football.task;

public interface IFootballTask {
    void scheduledMatchEvent() throws Exception;

    void scheduledTeam() throws Exception;

    void scheduledMatchSporttery() throws Exception;

    void scheduledScore() throws Exception;

    void scheduledOdds() throws Exception;
}
