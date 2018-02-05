package fr.esgi.schoolboyrun.activities;

import android.app.Dialog;
import android.content.res.Configuration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;


import java.util.Locale;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.fragments.MenuFragment;
import fr.esgi.schoolboyrun.fragments.UserFragment;
import fr.esgi.schoolboyrun.fragments.interfaces.IAskNameDialogFragment;
import fr.esgi.schoolboyrun.manager.UserManager;
import io.realm.Realm;

import static fr.esgi.schoolboyrun.helpers.PrefUtil.checkPrefValue;
import static fr.esgi.schoolboyrun.helpers.ViewUtil.initFragment;
import static fr.esgi.schoolboyrun.manager.UserManager.getCurrentUserManager;

public class MainActivity extends AppCompatActivity  implements IAskNameDialogFragment{

    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** initialisation de la persistance de donnée **/
        Realm.init(this);

        /** check if custom local exist in Pref file **/
        String customLocal = checkPrefValue(this,"local","local");

        if(!customLocal.isEmpty()){
            Locale locale = new Locale(customLocal);
            Configuration config = this.getResources().getConfiguration();
            config.locale = locale;
            this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        }

        /** init UserManager **/
        userManager = getCurrentUserManager();
        userManager.init(this);

        /** init UserFragment **/
        initFragment(this,UserFragment.newInstance(userManager.getUserName()),R.id.user_fragment);

        /** init MenuFragment **/
        initFragment(this,MenuFragment.newInstance(),R.id.menu_fragment);
    }

    @Override
    public void onDialogPositiveClick(Dialog dialog) {
        Log.i("[UserFragment] > ","onDialogPositiveClick");

        EditText mName = (EditText) dialog.findViewById(R.id.AskNameDialog_username);
        Log.i("[UserFragment] > ","mName > "+mName);

        UserManager userManager = UserManager.getCurrentUserManager();

        /** On met à jour le message de la home **/
        initFragment(this,UserFragment.newInstance(userManager.getUserName()),R.id.user_fragment);
    }
}