package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MatchHistoryDto {
    private Integer id;
    private Integer winnerId;
    private Integer loserId;
    private Integer tournamentId;
    private ZonedDateTime date;
    private String winner;
    private String loser;
    private TournamentDto tournament;
}
