package com.reksoft.exporter.model;

import lombok.Data;

@Data
public class Player {
    private Integer id;
    private String combinedName;
    private String fullName;
    private String nickname;
    private String country;
    private String teamName;
}
