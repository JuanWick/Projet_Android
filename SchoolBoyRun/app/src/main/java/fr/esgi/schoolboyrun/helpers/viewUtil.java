package fr.esgi.schoolboyrun.helpers;

import android.app.Activity;
import  android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.fragments.ScoresGoogleFragment;

/**
 * Created by JUAN_work on 08/01/2018.
 */

public class viewUtil extends AppCompatActivity {

    public static String checkPrefValue(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(key,MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }

    public static boolean isDualPane(Activity activity){
        View customView = activity.findViewById(R.id.custom_fragment);
        return customView != null && customView.getVisibility() == View.VISIBLE;
    }

    public static void initFragment(FragmentActivity activity, Fragment fragment, int containerViewId){

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.commit();
    }
}
