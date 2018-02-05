package fr.esgi.schoolboyrun.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.SchoolBoyRun;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import fr.esgi.schoolboyrun.manager.ScoreManager;
import fr.esgi.schoolboyrun.manager.UserManager;


public class GameActivity extends AndroidApplication {

    private int score;
    private Timer t;
    private SchoolBoyRun game;
    private ScoreManager scoreManager;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("[GameActivity]","onCreate");
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        game = new SchoolBoyRun();
        initialize(game, config);

        /** On récupère le score en cours dans le jeu **/
        t = new Timer();
        t.schedule(new CheckScore(), 0, 1*10);
    }

    class CheckScore extends TimerTask {
        public void run() {
            score = game.getScore();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        /** On fait persister le dernier score **/
        userManager = UserManager.getCurrentUserManager();
        scoreManager = new ScoreManager();

        scoreManager.saveScore(userManager.getUserName(), score, new Date());
        Log.i("[GameActivity]","onPause > score > " + score);
    }
}
