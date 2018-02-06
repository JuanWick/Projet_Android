package fr.esgi.schoolboyrun.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.fragments.interfaces.IAskNameDialogFragment;
import fr.esgi.schoolboyrun.fragments.interfaces.IUserFragment;
import fr.esgi.schoolboyrun.manager.UserManager;

import static fr.esgi.schoolboyrun.helpers.ViewUtil.initFragment;

public class UserFragment extends Fragment {
    private static final String ARG_PARAM1 = "userName";
    private String userName;
    private fr.esgi.schoolboyrun.fragments.interfaces.IUserFragment IUserFragment;
    private UserManager userManager;
    @BindView(R.id.fragment_user_name_txt) TextView mUserNameTxt;
    @BindView(R.id.fragment_user_edit_btn)  Button mUserEditBtn;
    @BindString(R.string.greeting) String GREETING;

    public UserFragment() {
    }

    /**
     * @param userName nom de l'utilisateur en cours.
     * @return A new instance of fragment UserFragment.
     */
    public static UserFragment newInstance(String userName) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if(null != getArguments().getString(ARG_PARAM1) && !getArguments().getString(ARG_PARAM1).isEmpty())
            userName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /** initialisation de la library butterknife **/
        ButterKnife.bind(this,getView());
        userManager = UserManager.getCurrentUserManager();

        if(null != userName && !userName.isEmpty()){
            mUserNameTxt.setText(GREETING+" "+userName+"!");
        } else {
            mUserNameTxt.setText(GREETING+"!");
        }

        mUserEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userManager.askUserName(getActivity(),"main");
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

