package com.example.lab7_673380391_3_sec3.service;

import com.example.lab7_673380391_3_sec3.model.Game;
import com.example.lab7_673380391_3_sec3.repository.GameRepository;
import com.example.lab7_673380391_3_sec3.strategy.DiscountContext;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    private void applyDiscountStrategy(Game game) {
        // คำนวณราคาสุทธิ
        game.setFinalPrice(DiscountContext.getFinalPrice(game.getDiscountType(), game.getPrice()));
        
        // เซ็ตชื่อโปรโมชั่นไปแสดงผลตามหน้า HTML ของอาจารย์
        String type = game.getDiscountType() != null ? game.getDiscountType().toUpperCase() : "NONE";
        switch (type) {
            case "STUDENT":
                game.setDiscountName("ส่วนลดนักศึกษา (10%)");
                break;
            case "SEASONAL":
                game.setDiscountName("เทศกาลลดราคา (20%)");
                break;
            case "NONE":
            default:
                game.setDiscountName("ราคาปกติ");
                break;
        }
    }

    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();
        for (Game game : games) {
            applyDiscountStrategy(game);
        }
        return games;
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public Game getGameById(Long id) {
        Optional<Game> optional = gameRepository.findById(id);
        if (optional.isPresent()) {
            Game game = optional.get();
            applyDiscountStrategy(game);
            return game;
        }
        throw new RuntimeException("Game not found for id :: " + id);
    }

    public void deleteGameById(Long id) {
        this.gameRepository.deleteById(id);
    }
}
