package com.androidprojects.vinit.idonate;

import android.app.Application;
import android.arch.persistence.room.Room;

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

}
