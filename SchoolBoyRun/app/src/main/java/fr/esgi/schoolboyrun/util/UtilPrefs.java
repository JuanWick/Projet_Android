package fr.esgi.schoolboyrun.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by JUAN_work on 08/01/2018.
 */

public class UtilPrefs extends AppCompatActivity {

    public static String checkPrefValue(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(key,MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
