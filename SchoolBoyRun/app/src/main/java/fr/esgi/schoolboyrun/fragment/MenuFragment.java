package fr.esgi.schoolboyrun.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.activity.GameActivity;
import fr.esgi.schoolboyrun.activity.MainActivity;
import fr.esgi.schoolboyrun.util.UtilPrefs;

import static android.content.Context.MODE_PRIVATE;

public class MenuFragment extends Fragment {
    private Button mPlayButton;
    Button mScoreButton;
    Button mParamButton;
    Button mScoreGoogleButton;

    public MenuFragment() {
    }

    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPlayButton = (Button) getActivity().findViewById(R.id.fragment_menu_play_btn);
        mScoreButton = (Button) getActivity().findViewById(R.id.fragment_menu_score_btn);
        mScoreGoogleButton = (Button) getActivity().findViewById(R.id.fragment_menu_score_google_btn);
        mParamButton = (Button) getActivity().findViewById(R.id.fragment_menu_param_btn);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameIntent = new Intent(getActivity(), GameActivity.class);
                startActivity(gameIntent);
            }
        });

        mScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Le score est demandé par "+UtilPrefs.checkPrefValue(getContext(),"currentUser"),Toast.LENGTH_SHORT).show();
            }
        });

        mScoreGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Le score google est demandé par "+UtilPrefs.checkPrefValue(getContext(),"currentUser"),Toast.LENGTH_SHORT).show();
            }
        });

        mParamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Les params sont demandé par "+ UtilPrefs.checkPrefValue(getContext(),"currentUser"),Toast.LENGTH_SHORT).show();
            }
        });
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
