package fr.esgi.schoolboyrun.activities;

import android.app.Dialog;
import android.content.res.Configuration;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


import java.util.Locale;

import butterknife.ButterKnife;
import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.data.impl.UserRepository;
import fr.esgi.schoolboyrun.fragments.AskNameDialogFragment;
import fr.esgi.schoolboyrun.fragments.interfaces.IAskNameDialogFragment;
import fr.esgi.schoolboyrun.fragments.interfaces.IUserFragment;
import fr.esgi.schoolboyrun.fragments.MenuFragment;
import fr.esgi.schoolboyrun.fragments.UserFragment;
import fr.esgi.schoolboyrun.models.User;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements IUserFragment, IAskNameDialogFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** initialisation de la persistance de donnée **/
        Realm.init(this);

        /** check if custom local exist in Pref file **/
        String customLocal = checkPrefValue("local");

        if(!customLocal.isEmpty()){
            Locale locale = new Locale(customLocal);
            Configuration config = this.getResources().getConfiguration();
            config.locale = locale;
            this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        }

        /** init UserFragment **/
        UserFragment userFragment = UserFragment.newInstance(getLastUserName());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction userFragmentTransaction = fragmentManager.beginTransaction();
        userFragmentTransaction.replace(R.id.user_fragment, userFragment);
        userFragmentTransaction.commit();

        /** init MenuFragment **/
        MenuFragment menuFragment = MenuFragment.newInstance();

        FragmentTransaction menuFragmentTransaction = fragmentManager.beginTransaction();
        menuFragmentTransaction.replace(R.id.menu_fragment, menuFragment);
        menuFragmentTransaction.commit();
    }

    @Override
    public void getUserName() {
        DialogFragment newFragment = new AskNameDialogFragment();
        newFragment.show(getSupportFragmentManager(), "askName");
    }

    @Override
    public void onDialogPositiveClick(Dialog dialog) {
        EditText mName = (EditText) dialog.findViewById(R.id.AskNameDialog_username);
        setLastUserName(mName.getText().toString());

        UserFragment updateUserFragment = UserFragment.newInstance(getLastUserName());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.user_fragment, updateUserFragment);
        fragmentTransaction.commit();
    }

    private String getLastUserName(){
        SharedPreferences sharedPreferences = this.getSharedPreferences("currentUser",MODE_PRIVATE);

        return sharedPreferences.getString("currentUser","");
    }

    private void setLastUserName(String name) {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User(name));

        SharedPreferences sharedPreferences = this.getSharedPreferences("currentUser",MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("currentUser", name);
        edit.commit();
    }

    private String checkPrefValue(String key){
        SharedPreferences sharedPreferences = this.getSharedPreferences(key,MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}