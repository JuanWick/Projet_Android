package fr.esgi.schoolboyrun.data.impl;

import android.util.Log;

import java.util.List;

import fr.esgi.schoolboyrun.data.IScoreRepository;
import fr.esgi.schoolboyrun.models.Score;
import fr.esgi.schoolboyrun.models.User;
import io.realm.Realm;

/**
 * Created by JUAN_work on 05/02/2018.
 */

public class ScoreRepository implements IScoreRepository{
    @Override
    public void addScore(Score score) {
        Log.i("[ScoreRepository]","ADD : "+score.getUserName()+"/"+score.getScore());

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(score);
        realm.commitTransaction();

        Log.i("[ScoreRepository]","ADD END");
    }

    @Override
    public List<Score> getAllScore() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Score.class).findAll();
    }
}
