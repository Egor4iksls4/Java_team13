package com.reksoft.exporter.service;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.repository.PlayerApiRepository;
import com.reksoft.exporter.repository.TeamApiRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import com.reksoft.exporter.repository.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamCsvReportService {

    private final TeamApiRepository teamRepository;
    private final PlayerApiRepository playerRepository;

    public File generateReport(String filePath) throws IOException {
        List<TeamDto> teams = teamRepository.getTeams();
        List<PlayerViewDto> players = playerRepository.getPlayers();
        File file = new File(filePath);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeNext(new String[]{"Id", "Team Name", "Players"});
            for (TeamDto team : teams) {
                String playerNames = players.stream()
                        .filter(player -> team.getName().equals(player.getTeamName()))
                        .map(PlayerViewDto::getCombinedName)
                        .collect(Collectors.joining(", "));
                writer.writeNext(new String[]{
                        String.valueOf(team.getId()),
                        team.getName(),
                        playerNames
                });
            }
        }
        return file;
    }
}