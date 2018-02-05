package fr.esgi.schoolboyrun.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.schoolboyrun.R;

import static fr.esgi.schoolboyrun.helpers.PrefUtil.addStringPrefValue;
import static fr.esgi.schoolboyrun.helpers.PrefUtil.checkPrefValue;

public class SettingsFragment extends Fragment {

    @BindView(R.id.radioGroup_language) RadioGroup radioGroup;
    @BindView(R.id.radio_english) RadioButton rdEnglish;
    @BindView(R.id.radio_french) RadioButton rdFrench;

    public SettingsFragment() {
    }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /** initialisation de la library butterknife **/
        ButterKnife.bind(this,getView());

        /** On check la valeur par default **/
        String customLocal = checkPrefValue(getActivity(),"local","local");

        if("FRENCH".equals(customLocal)){
            rdFrench.setChecked(true);
            rdEnglish.setChecked(false);
        } else {
            rdFrench.setChecked(false);
            rdEnglish.setChecked(true);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String local;
                if(checkedId == rdFrench.getId()){
                    local = "FRENCH";
                    addStringPrefValue(getActivity(),"local", "local",local);
                } else {
                    local = "ENGLISH";
                    addStringPrefValue(getActivity(),"local", "local",local);
                }

                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle(getString(R.string.Changement_langue));
                alertDialog.setMessage(getString(R.string.Changement_langue_restart));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
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
