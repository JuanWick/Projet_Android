package fr.esgi.schoolboyrun.manager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import fr.esgi.schoolboyrun.data.impl.UserRepository;
import fr.esgi.schoolboyrun.fragments.AskNameDialogFragment;
import fr.esgi.schoolboyrun.helpers.PrefUtil;
import fr.esgi.schoolboyrun.models.User;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by JUAN_work on 12/01/2018.
 */

public class UserManager {
    private User currentUser;
    private static UserManager CURRENTUSERMANAGER = new UserManager();


    private UserManager() {
    }

    public static UserManager getCurrentUserManager(){
        return CURRENTUSERMANAGER;
    }

    public void init(Activity activity){
        Log.i("[init]","DEBUT");
        SharedPreferences sharedPreferences = activity.getSharedPreferences("currentUser",MODE_PRIVATE);
        if(-1 != sharedPreferences.getInt("currentUserId",-1)){
            Log.i("[init]","existe");
            currentUser = new User(sharedPreferences.getInt("currentUserId",-1), sharedPreferences.getString("currentUserName",""));
        } else {
            Log.i("[init]","nope");
            currentUser = null;
        }
        Log.i("[init]","FIN");
    }

    public boolean checkUserIsSet(){
        return null != currentUser && currentUser.getId() != -1 ;
    }

    public String getUserName(){
        if(null != currentUser){
            return currentUser.getName();
        }
        return "";
    }

    public void askUserName(FragmentActivity fragment){
        DialogFragment newFragment = new AskNameDialogFragment();
        newFragment.show(fragment.getSupportFragmentManager(), "askName");
    }

    public void setLastUser(Context context, String name){
        Log.i("[setLastUser]","DEBUT > "+name);
        User user = new User();
        user.setName(name);

        UserRepository userRepository = new UserRepository();
        userRepository.addUser(user);

        Log.i("[setLastUser]","APRES ADD");


        user = userRepository.getUserByName(name);

        Log.i("[setLastUser]","APRES RECUP : " + user.getName());


        PrefUtil.addStringPrefValue(context, "currentUser", "currentUserName", name);
        PrefUtil.addIntPrefValue(context, "currentUser", "currentUserId", user.getId());

        Log.i("[setLastUser]","FIN");

    }
}
