package com.example.gamescore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gamescore.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

  
}