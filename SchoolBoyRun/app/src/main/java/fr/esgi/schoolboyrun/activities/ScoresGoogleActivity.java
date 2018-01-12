package fr.esgi.schoolboyrun.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.fragments.ScoresGoogleFragment;

import static fr.esgi.schoolboyrun.helpers.viewUtil.initFragment;

public class ScoresGoogleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_google);

        initFragment(this,ScoresGoogleFragment.newInstance(), R.id.scoresGoogle_fragment);
    }
}
