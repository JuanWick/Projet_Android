package fr.esgi.schoolboyrun.data.impl;

import android.util.Log;

import java.util.List;

import fr.esgi.schoolboyrun.data.IScoreRepository;
import fr.esgi.schoolboyrun.models.Score;
import fr.esgi.schoolboyrun.models.User;
import io.realm.Realm;
import io.realm.Sort;

/**
 * Created by JUAN_work on 05/02/2018.
 */

public class ScoreRepository implements IScoreRepository{
    @Override
    public void addScore(Score score) {
        Log.i("[ScoreRepository]","ADD : "+score.getUserName()+"/"+score.getScore());

        Realm realm = Realm.getDefaultInstance();

        Number currentIdNum = realm.where(Score.class).max("id");
        int nextId;
        if(currentIdNum == null) {
            nextId = 1;
        } else {
            nextId = currentIdNum.intValue() + 1;
        }
        score.setId(nextId);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(score);
        realm.commitTransaction();

        Log.i("[ScoreRepository]","ADD END");
    }

    @Override
    public List<Score> getAllScore() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Score.class).sort("score", Sort.DESCENDING).findAll();
    }
}
