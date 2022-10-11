package com.example.mysummerproject.services;

import com.example.mysummerproject.models.Game;
import com.example.mysummerproject.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> gameList() {
        return gameRepository.findAll();
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public Game show(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public void update(Game game) {
        Game gameFromDb = show(game.getId());
        gameFromDb.setName(game.getName());
        gameFromDb.setGenre(game.getGenre());
        gameFromDb.setStatus(game.getStatus());
        gameFromDb.setPlatform(game.getPlatform());
        gameFromDb.setRelease(game.getRelease());
        gameFromDb.setPlayDate(game.getPlayDate());
        gameRepository.save(game);
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);
    }

}
