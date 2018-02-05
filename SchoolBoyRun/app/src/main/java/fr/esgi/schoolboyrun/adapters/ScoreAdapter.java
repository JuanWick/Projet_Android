package fr.esgi.schoolboyrun.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.models.Score;

/**
 * Created by JUAN_work on 05/02/2018.
 */

public class ScoreAdapter extends ArrayAdapter<Score> {

    public ScoreAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public ScoreAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ScoreAdapter(@NonNull Context context, int resource, @NonNull Score[] objects) {
        super(context, resource, objects);
    }

    public ScoreAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Score[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ScoreAdapter(@NonNull Context context, int resource, @NonNull List<Score> objects) {
        super(context, resource, objects);
    }

    public ScoreAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Score> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.list_raw_score,null);

        TextView dateListView = (TextView) row.findViewById(R.id.txt_score_date);
        TextView userNameListView = (TextView) row.findViewById(R.id.txt_score_username);
        TextView valueListView = (TextView) row.findViewById(R.id.txt_score_value);


        Score scoreCurrent = getItem(position);

        userNameListView.setText(scoreCurrent.getUserName());
        valueListView.setText(String.valueOf(scoreCurrent.getScore()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        dateListView.setText(simpleDateFormat.format(scoreCurrent.getDate()));

        return row;
    }
}
