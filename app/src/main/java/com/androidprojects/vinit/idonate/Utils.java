package com.androidprojects.vinit.idonate;

import android.content.Context;
import android.preference.PreferenceManager;

public class Utils {

    public static String LOGIN_ID="loginId";
    public static String OTP_RECEIVED="otpReceived";
    public static String OTP="otp";
    public static String CURRENT_BALANCE="currentBalance";
    public static String PHONE_NO="phoneNo";
    public static String DONATION_AMOUNT="donationAmount";
    public static String DO_TRANSACTION="doTransaction";
    public static String NGO_SELECTED="ngoSelected";
    public static String PASS_CODE ="passCode";
    public static String DONATION_LIMIT="donationLimit";
    public static String NEAREST="nearest";
    public static String DONATE="donate";

    public static String SERVER_URL="";
    public static String PIC_URL=SERVER_URL+"pics/";
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

    public static void setParamStr(Context ctx,String str,String def){
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putString(str,def).commit();
    }

    public static void setParamL(Context ctx,String str,long def){
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putLong(str,def).commit();
    }

    public static void setParamI(Context ctx,String str,int def){
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putInt(str,def).commit();
    }

    public static void setParamB(Context ctx,String str,boolean def){
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putBoolean(str,def).commit();
    }

    public static int getPx(Context c, float dp){
        return (int)(c.getResources().getDisplayMetrics().density*dp);
    }
}

