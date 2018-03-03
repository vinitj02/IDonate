package com.androidprojects.vinit.idonate.services;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.androidprojects.vinit.idonate.activities.ChooseNgoActivity;
import com.androidprojects.vinit.idonate.activities.DonateActivity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class PopupService extends Service {
    private Timer timer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initializeTimer();
        return START_REDELIVER_INTENT;
    }

    //function for getting package name of the foreground app

    public String getForegroundApp() {
        String currentApp = null;
        long time = System.currentTimeMillis();
        List<UsageStats> appList = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            UsageStatsManager usm = (UsageStatsManager) this.getSystemService(Context.USAGE_STATS_SERVICE);
            appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, time - 1000 * 1000, time);
            if (appList != null && appList.size() > 0) {
                TreeMap<Long, UsageStats> mySortedMap = new TreeMap<Long, UsageStats>();
                for (UsageStats usageStats : appList) {
                    mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
                }
                if (mySortedMap != null && !mySortedMap.isEmpty()) {
                    currentApp = mySortedMap.get(mySortedMap.lastKey()).getPackageName();
                }
            }
        } else {
            ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> tasks = am.getRunningAppProcesses();
            currentApp = tasks.get(0).processName;
        }
        return currentApp;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    private void initializeTimer() {
        if(timer==null){
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    String fa = getForegroundApp();
                    fa=fa.toLowerCase();
                    if(fa.contains("uber") || fa.contains("ola")){
                        (new AlertDialog.Builder(PopupService.this))
                                .setTitle("IDonate")
                                .setMessage("If you are going walking distance, why not walk it and use that money to help someone.")
                                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                })
                                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        startActivity(new Intent(PopupService.this, ChooseNgoActivity.class));
                                    }
                                });
                    }
                }
            }, 1000, 100);
        }
    }
}
