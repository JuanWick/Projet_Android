package fr.esgi.schoolboyrun.models;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by JUAN_work on 09/01/2018.
 */

public class User extends RealmObject {
    @PrimaryKey
    private int id;
    @Required
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name){this.id = id; this.name = name;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
