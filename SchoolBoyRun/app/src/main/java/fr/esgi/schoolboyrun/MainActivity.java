package fr.esgi.schoolboyrun;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mPlayButton;
    private Button mScoreButton;
    private Button mScoreGoogleButton;
    private Button mRenameButton;
    private Button mParamButton;
    private TextView mGreetingText;
    private EditText mNameInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = (TextView)findViewById(R.id.activity_main_greeting_txt);
        mNameInputText = (EditText) findViewById(R.id.activity_main_input);

        mRenameButton = (Button) findViewById(R.id.activity_main_rename_btn);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);
        mScoreButton = (Button) findViewById(R.id.activity_main_score_btn);
        mScoreGoogleButton = (Button) findViewById(R.id.activity_main_score_google_btn);
        mParamButton = (Button) findViewById(R.id.activity_main_param_btn);


        String userName = getLastUserName();
        layoutNewUser(userName.isEmpty());

        mRenameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutNewUser(true);
            }
        });

        mNameInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setLastUserName(charSequence.toString());
                if(!charSequence.toString().isEmpty()){
                    mPlayButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"La partie commence "+getLastUserName(),Toast.LENGTH_SHORT).show();
            }
        });

        mScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Le score est demandé "+getLastUserName(),Toast.LENGTH_SHORT).show();
            }
        });

        mScoreGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Le score google est demandé "+getLastUserName(),Toast.LENGTH_SHORT).show();
            }
        });

        mParamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Les params de "+getLastUserName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void layoutNewUser(boolean isNew) {
        mPlayButton.setEnabled(!isNew);
        if(isNew){
            mNameInputText.setVisibility(View.VISIBLE);
            mRenameButton.setVisibility(View.GONE);
            mGreetingText.setText("Comment doit-on t'appeler ?");
        } else {
            mNameInputText.setVisibility(View.GONE);
            mRenameButton.setVisibility(View.VISIBLE);
            mGreetingText.setText("Content de te revoir "+getLastUserName()+" !");
        }
    }

    private String getLastUserName(){
        SharedPreferences sharedPreferences = this.getSharedPreferences("currentUser",MODE_PRIVATE);

        return sharedPreferences.getString("currentUser","");
    }

    private void setLastUserName(String name) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("currentUser",MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("currentUser", name);
        edit.commit();
    }
}