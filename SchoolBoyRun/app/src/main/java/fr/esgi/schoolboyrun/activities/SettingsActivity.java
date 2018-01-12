package fr.esgi.schoolboyrun.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.fragments.SettingsFragment;

import static fr.esgi.schoolboyrun.helpers.viewUtil.initFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initFragment(this,SettingsFragment.newInstance(),R.id.settings_fragment);
    }
}
