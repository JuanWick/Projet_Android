package fr.esgi.schoolboyrun.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.esgi.schoolboyrun.R;

public class ScoresGoogleFragment extends Fragment {

    public ScoresGoogleFragment() {
    }

    public static ScoresGoogleFragment newInstance() {
        ScoresGoogleFragment fragment = new ScoresGoogleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scores_google, container, false);
    }

}
