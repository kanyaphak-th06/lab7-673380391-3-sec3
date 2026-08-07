package com.example.lab7_673380391_3_sec3.controller;

import com.example.lab7_673380391_3_sec3.model.Game;
import com.example.lab7_673380391_3_sec3.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String listGames(Model model) {
        // เปลี่ยนชื่อเป็น "games" ให้แมปกับ th:each="game, iter : ${games}" ของอาจารย์
        model.addAttribute("games", gameService.getAllGames());
        return "games/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("game", new Game());
        return "games/add";
    }

    @PostMapping("/save")
    public String saveGame(@ModelAttribute("game") Game game) {
        gameService.saveGame(game);
        return "redirect:/games";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable(value = "id") Long id, Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("game", game);
        return "games/edit";
    }

    @PostMapping("/update/{id}")
    public String updateGame(@PathVariable(value = "id") Long id, @ModelAttribute("game") Game game) {
        game.setId(id);
        gameService.saveGame(game);
        return "redirect:/games";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable(value = "id") Long id, Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("game", game);
        return "games/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable(value = "id") Long id) {
        gameService.deleteGameById(id);
        return "redirect:/games";
    }
}
