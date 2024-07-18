package com.example.gamescore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gamescore.entity.GameScore;
import com.example.gamescore.service.GameService;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private GameService scoreService;

    @PostMapping
    public ResponseEntity<Void> saveScore(@RequestParam int userId, @RequestParam int gameId, @RequestParam int score) {
        scoreService.saveScore(userId, gameId, score);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}/highest")
    public ResponseEntity<List<GameScore>> getHighestScoresForUser(@PathVariable int userId) {
        List<GameScore> highestScores = scoreService.getHighestScoresForUser(userId);
        return new ResponseEntity<>(highestScores, HttpStatus.OK);
    }

    @GetMapping("/games/{gameId}/top10")
    public ResponseEntity<List<GameScore>> getTopTenScoresForGame(@PathVariable int gameId) {
        List<GameScore> topScores = scoreService.getTopTenScoresForGame(gameId);
        return new ResponseEntity<>(topScores, HttpStatus.OK);
    }

    
}