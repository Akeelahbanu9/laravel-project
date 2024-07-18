package com.example.gamescore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gamescore.entity.GameScore;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<GameScore, Integer> {

    List<GameScore> findByUserIdOrderByScoreDesc(int userId);

    List<GameScore> findTopByUserIdOrderByScoreDesc(int userId);

    List<GameScore> findTop10ByGameIdOrderByScoreDesc(int gameId);


}
