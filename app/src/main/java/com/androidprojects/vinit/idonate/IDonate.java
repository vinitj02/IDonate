package com.androidprojects.vinit.idonate;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by ashis on 19-01-2018.
 */

public class IDonate extends Application {
    public AppDatabase db;

    public AppDatabase getDb(){
        if(db==null)db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "IDonateDatabase").build();;
        return  db;
    }

    void destroyDB(){
        db=null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this,Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }
}
