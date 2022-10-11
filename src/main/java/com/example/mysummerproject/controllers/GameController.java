package com.example.mysummerproject.controllers;

import com.example.mysummerproject.models.Game;
import com.example.mysummerproject.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") long id) {
        model.addAttribute("game", gameService.show(id));
        return "game/show";
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

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("game", gameService.show(id));
        return "game/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("game") Game game) {
        gameService.update(game);
        return "redirect:/game";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        gameService.delete(id);
        return "redirect:/game";
    }
}
