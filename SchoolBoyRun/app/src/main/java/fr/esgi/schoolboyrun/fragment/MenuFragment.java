package fr.esgi.schoolboyrun.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
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

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
    private Button mPlayButton;
    private Button mRenameButton;
    private TextView mGreetingText;
    private EditText mNameInputText;

    private OnFragmentInteractionListener mListener;

    public MenuFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MenuFragment.
     */
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
         /* check if custom local exist in Pref file */
         String customLocal = checkPrefValue("local");

        if(!customLocal.isEmpty()){
            Locale locale = new Locale(customLocal);
            Configuration config = this.getActivity().getResources().getConfiguration();
            config.locale = locale;
            this.getActivity().getResources().updateConfiguration(config, this.getActivity().getResources().getDisplayMetrics());
        }

//        mGreetingText = (TextView) getActivity().findViewById(R.id.fragment_menu_greeting_txt);
//        mNameInputText = (EditText) getActivity().findViewById(R.id.fragment_menu_input);
//        mRenameButton = (Button) getActivity().findViewById(R.id.fragment_menu_rename_btn);
        mPlayButton = (Button) getActivity().findViewById(R.id.fragment_menu_play_btn);
        Button mScoreButton = (Button) getActivity().findViewById(R.id.fragment_menu_score_btn);
        Button mScoreGoogleButton = (Button) getActivity().findViewById(R.id.fragment_menu_score_google_btn);
        Button mParamButton = (Button) getActivity().findViewById(R.id.fragment_menu_param_btn);


        String userName = checkPrefValue("currentUser");
        layoutNewUser(userName.isEmpty());

//        mRenameButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                layoutNewUser(true);
//            }
//        });
//
//        mNameInputText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                setLastUserName(charSequence.toString());
//                if(!charSequence.toString().isEmpty()){
//                    mPlayButton.setEnabled(true);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//            }
//        });

//        mPlayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent gameIntent = new Intent(getActivity(), GameActivity.class);
//                startActivity(gameIntent);
//            }
//        });
//
//        mScoreButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"Le score est demandé "+checkPrefValue("currentUser"),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mScoreGoogleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"Le score google est demandé "+checkPrefValue("currentUser"),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mParamButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"Les params de "+checkPrefValue("currentUser"),Toast.LENGTH_SHORT).show();
//            }
//        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void layoutNewUser(boolean isNew) {

        //mPlayButton.setEnabled(!isNew);
//        if(isNew){
//            mNameInputText.setVisibility(View.VISIBLE);
//            mRenameButton.setVisibility(View.GONE);
//            mGreetingText.setText(R.string.ask_name);
//        } else {
//            mNameInputText.setVisibility(View.GONE);
//            mRenameButton.setVisibility(View.VISIBLE);
//            mGreetingText.setText(String.format("%s%s !", this.getString(R.string.greeting), checkPrefValue("currentUser")));
//        }
    }

    private String checkPrefValue(String key){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(key,MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    };

    private void setLastUserName(String name) {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("currentUser",MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("currentUser", name);
        edit.apply();
    }
}
