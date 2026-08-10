package com.example.lab7_673380391_3_sec3.service;

import com.example.lab7_673380391_3_sec3.model.Game;
import com.example.lab7_673380391_3_sec3.repository.GameRepository;
import com.example.lab7_673380391_3_sec3.strategy.DiscountContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {
    
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    private void computePricesAndNames(Game game) {
        if (game == null) return;
        
        double finalPrice = DiscountContext.getNetPrice(game.getDiscountType(), game.getPrice());
        game.setFinalPrice(finalPrice);
        
        String type = game.getDiscountType() != null ? game.getDiscountType().toUpperCase() : "NONE";
        switch (type) {
            case "STUDENT":
                game.setDiscountName("ส่วนลดนักศึกษา (10%)");
                break;
            case "SEASONAL":
                game.setDiscountName("ส่วนลดเทศกาล (20%)");
                break;
            default:
                game.setDiscountName("ราคาปกติ");
                break;
        }
    }

    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();
        for (Game game : games) {
            computePricesAndNames(game);
        }
        return games;
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public Game getGameById(Long id) {
        Game game = gameRepository.findById(id).orElse(null);
        computePricesAndNames(game);
        return game;
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
