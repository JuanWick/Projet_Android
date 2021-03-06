package fr.esgi.schoolboyrun.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.SchoolBoyRun;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.helpers.PrefUtil;
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
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        game = new SchoolBoyRun();
        initialize(game, config);

        /** On récupère le score en cours dans le jeu **/
        t = new Timer();
        t.schedule(new CheckScore(), 0, 1);
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
        Toast.makeText(this,getString(R.string.score_toast)+ " " + score + " ! ",Toast.LENGTH_LONG).show();

        /** On enregistre le score max dans les prefs **/
        PrefUtil.addIntPrefValue(this,"maxScore","maxScore", scoreManager.getMaxScore());
    }
}
