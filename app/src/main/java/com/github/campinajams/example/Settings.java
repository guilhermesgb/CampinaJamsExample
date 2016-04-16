package com.github.campinajams.example;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {

    private static final String PREFS_FILENAME = "SHARED_PREFS";
    private static final String KEY_STORED_NAME = "KEY_STORED_NAME";

    public static String getSavedNameFromSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = getThisAppSharedPreferences(context);
        return sharedPreferences.getString(KEY_STORED_NAME, null);
    }

    public static void saveNewNameIntoSharedPreferences(Context context, String newName) {
        SharedPreferences sharedPreferences = getThisAppSharedPreferences(context);
        sharedPreferences
                .edit()
                .putString(KEY_STORED_NAME, newName)
                .apply();
    }

    private static SharedPreferences getThisAppSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
    }

}
