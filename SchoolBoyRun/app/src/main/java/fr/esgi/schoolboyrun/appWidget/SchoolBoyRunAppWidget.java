package fr.esgi.schoolboyrun.appWidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import fr.esgi.schoolboyrun.R;
import fr.esgi.schoolboyrun.activities.MainActivity;
import fr.esgi.schoolboyrun.manager.ScoreManager;

import static fr.esgi.schoolboyrun.helpers.PrefUtil.checkPrefValue;

/**
 * Implementation of App Widget functionality.
 */
public class SchoolBoyRunAppWidget extends AppWidgetProvider {

    public static final String ACTION_LANCER_APPLICATION = "fr.esgi.schoolboyrun.LANCER_APPLICATION";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        SharedPreferences maxScore = context.getSharedPreferences("maxScore",Context.MODE_PRIVATE);

        String widgetText = context.getString(R.string.appwidget_text) + " " + maxScore.getInt("maxScore", 0) + " !";
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.school_boy_run_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        appWidgetManager.updateAppWidget(appWidgetId, views);


        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setAction(ACTION_LANCER_APPLICATION);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        if (intent.getAction().equals(ACTION_LANCER_APPLICATION))
        {
            lancerActivityPrincipale(context);
        }
    }

    protected void lancerActivityPrincipale(Context context)
    {
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}

