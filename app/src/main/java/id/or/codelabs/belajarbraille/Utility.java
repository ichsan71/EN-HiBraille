package id.or.codelabs.belajarbraille;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utility {
    public static void setTheme(Context context, String theme) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString("theme", theme).commit();
    }
    public static String getTheme(Context context) {
        String prefs = PreferenceManager.getDefaultSharedPreferences(context).getString("theme", "Tema Default");
        return prefs;
    }
}
