package com.androidprojects.vinit.idonate.classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by ashis on 01-03-2018.
 */

@Entity
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public Long amount;
    public String to;
    public Date time;

    public Transaction() {}

    public Transaction(Long amount, String to, Date time) {
        this.amount = amount;
        this.to = to;
        this.time = time;
    }
}
