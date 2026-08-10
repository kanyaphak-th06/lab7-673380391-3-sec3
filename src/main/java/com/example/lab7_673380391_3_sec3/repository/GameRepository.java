package com.example.lab7_673380391_3_sec3.repository;

import com.example.lab7_673380391_3_sec3.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
