package com.example.soulshelperbackend.config;

import com.example.soulshelperbackend.dto.GameIgdbResponse;
import com.example.soulshelperbackend.entity.Game;
import com.example.soulshelperbackend.repositories.GameRepository;
import com.example.soulshelperbackend.service.GameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {
    final GameService gameService;

    public DeveloperData(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SetupGames();
    }

    private void SetupGames() {

        gameService.addGame(2155);
        gameService.addGame(11133);
        gameService.addGame(2368);
        gameService.addGame(7334);
        gameService.addGame(134606);
        gameService.addGame(228535);
        gameService.addGame(148241);
        gameService.addGame(21593);
        List<Game> gameIgdbResponses = gameService.getAllGames();
        for (Game gameIgdbRespons : gameIgdbResponses) {
            System.out.println(gameIgdbRespons);
        }
    }
}
