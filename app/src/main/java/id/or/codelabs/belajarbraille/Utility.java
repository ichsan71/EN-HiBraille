package id.or.codelabs.belajarbraille;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utility {
    public static void setTheme(Context context, String theme) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(context.getString(R.string.prefs_theme_key), theme).apply();
    }
    public static String getTheme(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        if (prefs.getString(context.getString(R.string.prefs_theme_key), null) == null){
            return null;
        }
        return prefs.getString(context.getString(R.string.prefs_theme_key), null);
    }
}
