package com.example.wirecard.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.example.wirecard.model.User;

/**
 * Application preference utils
 */
public class AppPreferenceUtils {

    private static String MY_PREFS_NAME = "MyPrefs";
    private static final String USER_KEY = "user";
    private static final String PASS_KEY = "pass";

    /**
     * Get user object
     * @param con
     * @return
     */
    public static User getUserData(Context con) {
        String valUserKeyPref = null;
        String valPassKeyPref = null;

        SharedPreferences preferences = con.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        if (preferences != null) {
            valUserKeyPref = preferences.getString(USER_KEY, null);
            valPassKeyPref = preferences.getString(PASS_KEY, null);
        }

        if(valUserKeyPref != null && valPassKeyPref != null){
            return new User(valUserKeyPref, valPassKeyPref);
        }
        return null;
    }

    /**
     * Deletr user object from database
     * @param con
     */
    public static void deleteUserData(Context con) {
        SharedPreferences preferences = con.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        if (preferences != null) {

            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(USER_KEY);
            editor.remove(PASS_KEY);

            editor.apply();
        }
    }

    /**
     * Put user and password in database
     * @param con
     * @param user
     * @return
     */
    public static boolean setUserData(Context con, User user) {
        SharedPreferences preferences = con.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        if (preferences != null &&
                user != null &&
                !TextUtils.isEmpty(user.getUser()) &&
                !TextUtils.isEmpty(user.getPassword())) {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(USER_KEY, user.getUser());
            editor.putString(PASS_KEY, user.getPassword());

            return editor.commit();
        }
        return false;
    }

}
