package com.androidprojects.vinit.idonate;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.androidprojects.vinit.idonate.classes.DateConverter;
import com.androidprojects.vinit.idonate.classes.Goal;
import com.androidprojects.vinit.idonate.classes.GoalDao;
import com.androidprojects.vinit.idonate.classes.NGO;
import com.androidprojects.vinit.idonate.classes.NGODao;
import com.androidprojects.vinit.idonate.classes.Transaction;
import com.androidprojects.vinit.idonate.classes.TransactionDao;

/**
 * Created by ashis on 19-01-2018.
 */

@Database(entities = {NGO.class, Goal.class, Transaction.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract NGODao ngoDao();
    public abstract GoalDao goalDao();
    public abstract TransactionDao transactionDao();
}
