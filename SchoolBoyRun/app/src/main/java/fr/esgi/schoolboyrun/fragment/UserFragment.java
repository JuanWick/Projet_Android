package fr.esgi.schoolboyrun.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.interfaces.iUserFragment;

public class UserFragment extends Fragment {
    private static final String ARG_PARAM1 = "userName";
    private String userName;
    private iUserFragment iUserFragment;

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
        TextView mUserNameTxt = (TextView) getView().findViewById(R.id.fragment_user_name_txt);

        if(null == userName || userName.isEmpty()){
            iUserFragment.getUserName();
        } else {
            mUserNameTxt.setText(getString(R.string.greeting)+userName+"!");
        }

        Button mUserEditBtn = (Button) getView().findViewById(R.id.fragment_user_edit_btn);

        mUserEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iUserFragment.getUserName();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof iUserFragment) {
            iUserFragment = (iUserFragment) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        iUserFragment = null;
    }
}
