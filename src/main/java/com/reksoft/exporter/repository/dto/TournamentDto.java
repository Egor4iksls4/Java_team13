package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class TournamentDto {
    private Integer id;
    private String name;
    private String organizer;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private List<TournamentParticipantInfoDto> teamParticipantInfos;
    private List<TournamentPrizeDto> tournamentPrizes;
}
