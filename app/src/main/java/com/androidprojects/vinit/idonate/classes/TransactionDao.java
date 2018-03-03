package com.androidprojects.vinit.idonate.classes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
@Dao
public interface TransactionDao {

    @Query("SELECT * FROM `transaction` ORDER BY time DESC")
    ArrayList<Transaction> getTransactions();

    @Insert
    void insert(Transaction transaction);

    @Update
    void update(ArrayList<NGO> transactions);
}
