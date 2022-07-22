package com.example.mysummerproject.controllers;

import com.example.mysummerproject.models.Game;
import com.example.mysummerproject.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @GetMapping()
    public String games(Model model) {
        model.addAttribute("games", gameService.gameList());
        return "game/games";
    }

    @GetMapping("/new")
    public String newGame(@ModelAttribute("game") Game game) {
        return "game/new";
    }

    @PostMapping
    public String create(@ModelAttribute("game") Game game) {
        gameService.saveGame(game);
        return "redirect:/game";
    }
}
