package fr.esgi.schoolboyrun.data;

import java.util.List;

import fr.esgi.schoolboyrun.models.User;

/**
 * Created by JUAN_work on 10/01/2018.
 */

public interface IUserRepository {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User getUserByName(String name);
    public User getUserById(int id);
    public List<User> getAllUser();
}
