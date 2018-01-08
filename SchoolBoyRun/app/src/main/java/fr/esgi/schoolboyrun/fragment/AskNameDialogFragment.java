package fr.esgi.schoolboyrun.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.interfaces.iAskNameDialogFragment;

/**
 * Created by JUAN_work on 07/01/2018.
 */

public class AskNameDialogFragment extends DialogFragment {

    iAskNameDialogFragment iAskNameDialogFragment;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.ask_name)
                .setPositiveButton(R.string.lets_start, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        iAskNameDialogFragment.onDialogPositiveClick(getDialog());
                    }
                });
        builder.setView(R.layout.dialog_ask_name);
        builder.setCancelable(false);
        return builder.create();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof iAskNameDialogFragment){
            iAskNameDialogFragment = (iAskNameDialogFragment) context;
        }
    }
}
