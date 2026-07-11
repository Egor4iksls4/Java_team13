package com.reksoft.exporter.repository.dto;

import lombok.Data;

@Data
public class PlayerViewDto {
    private Integer id;
    private String combinedName;
    private String nickName;
    private String country;
    private String teamName;
}
