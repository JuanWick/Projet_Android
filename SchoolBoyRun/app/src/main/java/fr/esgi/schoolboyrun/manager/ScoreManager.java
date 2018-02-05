package fr.esgi.schoolboyrun.manager;

import java.util.Date;
import java.util.List;

import fr.esgi.schoolboyrun.data.impl.ScoreRepository;
import fr.esgi.schoolboyrun.data.impl.UserRepository;
import fr.esgi.schoolboyrun.models.Score;
import fr.esgi.schoolboyrun.models.User;

/**
 * Created by JUAN_work on 12/01/2018.
 */

public class ScoreManager {
    public ScoreManager() {
    }

    /**
     * Persiste le score du joueur en local et eventuelement sur le playStore
     */
    public void saveScore(String userName, int score, Date date){
        Score scoreOb = new Score();
        scoreOb.setDate(date);
        scoreOb.setScore(score);
        scoreOb.setUserName(userName);
        ScoreRepository scoreRepository = new ScoreRepository();
        scoreRepository.addScore(scoreOb);
    }

    public List<Score> getAllScores(){
        ScoreRepository scoreRepository = new ScoreRepository();

        return scoreRepository.getAllScore();
    }

    public int getMaxScore(){
        ScoreRepository scoreRepository = new ScoreRepository();

        return scoreRepository.getMaxScore();
    }
}
