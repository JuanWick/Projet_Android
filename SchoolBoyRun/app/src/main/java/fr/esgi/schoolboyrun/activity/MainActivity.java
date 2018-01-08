package fr.esgi.schoolboyrun.activity;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.fragment.AskNameDialogFragment;
import fr.esgi.schoolboyrun.fragment.UserFragment;
import fr.esgi.schoolboyrun.interfaces.iAskNameDialogFragment;
import fr.esgi.schoolboyrun.interfaces.iUserFragment;

public class MainActivity extends AppCompatActivity implements iUserFragment, iAskNameDialogFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** On initialise UserFragment **/
        UserFragment userFragment = UserFragment.newInstance(getLastUserName());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.user_fragment, userFragment);
        fragmentTransaction.commit();
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
        SharedPreferences sharedPreferences = this.getSharedPreferences("currentUser",MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("currentUser", name);
        edit.commit();
    }
}