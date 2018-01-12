package fr.esgi.schoolboyrun.data.impl;

import android.util.Log;

import java.util.List;

import fr.esgi.schoolboyrun.data.IUserRepository;
import fr.esgi.schoolboyrun.models.User;
import io.realm.Realm;

/**
 * Created by JUAN_work on 10/01/2018.
 */

public class UserRepository implements IUserRepository {
    @Override
    public void addUser(User user) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    @Override
    public void updateUser(User user) {

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
        Realm realm = Realm.getDefaultInstance();
        return realm.where(User.class).equalTo("id",id).findFirst();
    }

    @Override
    public List<User> getAllUser() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(User.class).findAll();
    }
}
