package com.androidprojects.vinit.idonate;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by ashis on 17-01-2018.
 */

public class Utils {

    final static String LOGIN_ID="loginId";

    static String getParamStr(Context ctx,String str,String def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString(str,def);
    }

    static long getParamL(Context ctx,String str,long def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getLong(str,def);
    }

    static int getParamI(Context ctx,String str,int def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getInt(str,def);
    }

    static boolean getParamB(Context ctx,String str,boolean def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean(str,def);
    }
}

