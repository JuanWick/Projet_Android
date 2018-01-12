package fr.esgi.schoolboyrun.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by JUAN_work on 10/01/2018.
 */

public class Score extends RealmObject {
    @PrimaryKey
    private int id;
    private int score;
    @Required
    private Date date;
    private User owner;

    public Score() {
    }

    public Score(int id, int score, Date date, User owner) {
        this.id = id;
        this.score = score;
        this.date = date;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
