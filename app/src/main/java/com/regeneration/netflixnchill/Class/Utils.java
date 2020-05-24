package com.regeneration.netflixnchill.Class;

import android.content.Context;

public class Utils {
    public static String api_key = "0c0b169072612ced994048362b7f5c01";

    public static boolean loggedin = true;

    public static int dpToPx(Context context, int dp) {
        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }

    public static boolean isLoggedin() {
        return loggedin;
    }

    public static void setLoggedin(boolean value) {
        loggedin = value;
    }
}

