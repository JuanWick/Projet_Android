package fr.esgi.schoolboyrun.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.adapters.ScoreAdapter;
import fr.esgi.schoolboyrun.manager.ScoreManager;
import fr.esgi.schoolboyrun.models.Score;

public class ScoresFragment extends Fragment {

    public ScoresFragment() {
    }

    public static ScoresFragment newInstance() {
        ScoresFragment fragment = new ScoresFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /** On récupère la liste des scores **/
        ScoreManager scoreManager = new ScoreManager();
        List<Score> scores = scoreManager.getAllScores();

        Log.i("[ScoresFragment]","LE NOMBRE : "+scores.size());

        /** On configure l'adapter **/
        ScoreAdapter scoreAdapter = new ScoreAdapter(this.getActivity(),android.R.layout.simple_list_item_1,scores);

        /** On assigne l'adapter à la vue **/
        View currentView = inflater.inflate(R.layout.fragment_scores, container, false);

        ListView listv = (ListView) currentView.findViewById(R.id.scorelist);
        listv.setAdapter(scoreAdapter);

        return currentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
