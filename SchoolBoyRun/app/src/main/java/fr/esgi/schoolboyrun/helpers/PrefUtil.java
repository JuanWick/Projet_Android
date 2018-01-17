package fr.esgi.schoolboyrun.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by JUAN_work on 12/01/2018.
 */

public class PrefUtil {

    public static String checkPrefValue(Context context, String pref, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(pref,MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }

    public static void addStringPrefValue(Context context, String pref, String key, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(pref,MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        edit.commit();
    }
    public static void addIntPrefValue(Context context, String pref, String key, int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(pref,MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key, value);
        edit.commit();
    }
}
