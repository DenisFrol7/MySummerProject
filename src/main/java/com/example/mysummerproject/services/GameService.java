package com.example.mysummerproject.services;

import com.example.mysummerproject.models.Game;
import com.example.mysummerproject.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> gameList() {
        return gameRepository.findAll();
    }
}
