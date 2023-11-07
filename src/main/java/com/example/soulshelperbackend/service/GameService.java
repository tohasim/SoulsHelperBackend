package com.example.soulshelperbackend.service;

import com.example.soulshelperbackend.api_facade.IgdbFacade;
import com.example.soulshelperbackend.dto.GameIgdbResponse;
import com.example.soulshelperbackend.entity.Game;
import com.example.soulshelperbackend.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GameService {
    GameRepository gameRepository;
    @Autowired
    IgdbFacade igdbFacade;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game addGame(int igdbId) {
        GameIgdbResponse dto = igdbFacade.getGame(igdbId);

        Game game = Game.builder()
                .id(dto.getId())
                .name(dto.getName())
                .coverId(dto.getCoverId())
                .summary(dto.getSummary())
                .build();
        try {
            gameRepository.save(game);
            return game;
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getRootCause().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add game");
        }
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
