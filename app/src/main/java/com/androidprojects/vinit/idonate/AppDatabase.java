package com.androidprojects.vinit.idonate;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.androidprojects.vinit.idonate.classes.NGO;
import com.androidprojects.vinit.idonate.classes.NGODao;

/**
 * Created by ashis on 19-01-2018.
 */

@Database(entities = {NGO.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NGODao ngoDao();
}
