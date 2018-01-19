package com.androidprojects.vinit.idonate;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by ashis on 17-01-2018.
 */

public class Utils {

    public static String LOGIN_ID="loginId";
    public static int PHONE_HINT=0;

    public static  String getParamStr(Context ctx,String str,String def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString(str,def);
    }

    public static  long getParamL(Context ctx,String str,long def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getLong(str,def);
    }

    public static  int getParamI(Context ctx,String str,int def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getInt(str,def);
    }

    public static  boolean getParamB(Context ctx,String str,boolean def){
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean(str,def);
    }
}

