package com.example.suphuy.assigmment_huyphpk00628.Control;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by SUPHUY on 9/25/2016.
 */
@SuppressWarnings("deprecation")
public class SetTingLanguage{
        /* ------------------------------------- */
        private static Locale myLocale;
        private String lang = "";
        // Lưu ngôn ngữ đã cài đặt
        public static void saveLocale(String lang, Activity activity) {
            String langPref = "Language";
            SharedPreferences prefs =  activity.getSharedPreferences("CommonPrefs",
                    Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(langPref, lang);
            editor.commit();
        }
        // Load lại ngôn ngữ đã lưu và thay đổi chúng
        public static void loadLocale(Activity activity) {
            String langPref = "Language";
            SharedPreferences prefs = activity.getSharedPreferences("CommonPrefs",
                    Activity.MODE_PRIVATE);
            String language = prefs.getString(langPref, "");
            changeLang(language, activity);
        }
        // method phục vụ cho việc thay đổi ngôn ngữ.
        public static void changeLang(String lang,Activity activity) {
            if (lang.equalsIgnoreCase(""))
                return;
            myLocale = new Locale(lang);
            saveLocale(lang, activity);
            Locale.setDefault(myLocale);
            android.content.res.Configuration config = new android.content.res.Configuration();
            config.locale = myLocale;
            activity.getBaseContext().getResources().updateConfiguration(config,
                    activity.getBaseContext().getResources().getDisplayMetrics());

        }

}