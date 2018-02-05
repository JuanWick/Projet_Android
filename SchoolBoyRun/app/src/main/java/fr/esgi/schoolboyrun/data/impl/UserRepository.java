package fr.esgi.schoolboyrun.data.impl;

import android.util.Log;

import java.util.List;

import fr.esgi.schoolboyrun.data.IUserRepository;
import fr.esgi.schoolboyrun.models.Score;
import fr.esgi.schoolboyrun.models.User;
import io.realm.Realm;

/**
 * Created by JUAN_work on 10/01/2018.
 */

public class UserRepository implements IUserRepository {
    @Override
    public void addUser(User user) {
        Log.i("[UserRepository]","ADD : "+user.getName());

        Realm realm = Realm.getDefaultInstance();

        Number currentIdNum = realm.where(User.class).max("id");
        int nextId;
        if(currentIdNum == null) {
            nextId = 1;
        } else {
            nextId = currentIdNum.intValue() + 1;
        }
        user.setId(nextId);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

        Log.i("[UserRepository]","ADD END");
    }

    @Override
    public void updateUser(User user) {
        addUser(user);
    }

    @Override
    public void deleteUser(User user) {
//        Realm realm = Realm.getDefaultInstance();
//
//        realm.beginTransaction();
//        User result = realm.where(User.class).equalTo("id", user.getId()).findFirst();
//        result.deleteFromRealm();
//        realm.commitTransaction();
    }

    @Override
    public User getUserByName(String name) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(User.class).equalTo("name",name).findFirst();
    }

    @Override
    public User getUserById(int id) {
        Log.i("[UserRepository]","ADD END");

        Realm realm = Realm.getDefaultInstance();
        return realm.where(User.class).equalTo("id",id).findFirst();
    }

    @Override
    public List<User> getAllUser() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(User.class).findAll();
    }
}
