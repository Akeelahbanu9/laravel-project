package com.example.gamescore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gamescore.entity.Game;
import com.example.gamescore.entity.GameScore;
import com.example.gamescore.entity.User;
import com.example.gamescore.repository.GameRepository;
import com.example.gamescore.repository.ScoreRepository;

@Service
public class GameService {

	    @Autowired
	    private ScoreRepository scoreRepository;
	    
	    @Autowired
	    private GameRepository gameRepository;

	    
	    
	    public void saveScore(int userId, int gameId, int score) {
	        GameScore newScore = new GameScore();
	        newScore.setUser(new User());
	        newScore.setGame(new Game());
	        newScore.setScore(score);
	        
	        scoreRepository.save(newScore);
	    }
	    
	    
	    public List<GameScore> getHighestScoresForUser(int userId) {
	        return scoreRepository.findTopByUserIdOrderByScoreDesc(userId);
	    }

	    
	    public List<GameScore> getTopTenScoresForGame(int gameId) {
	        return scoreRepository.findTop10ByGameIdOrderByScoreDesc(gameId);
	    }

	 
	    public Game createGame(Game game) {
	     
	        return gameRepository.save(game);
	    }

	    public Game getGameById(int gameId) {
	        return gameRepository.findById(gameId).orElse(null);
	    }

	    public List<Game> getAllGames() {
	        return gameRepository.findAll();
	    }


	}

