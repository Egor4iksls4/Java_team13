package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class RatingDto {
    private Integer id;
    private Integer score;
    private ZonedDateTime atMoment;
    private Integer teamId;
    private TeamDto team;
}