package com.androidprojects.vinit.idonate.classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/**
 * Created by Vinit on 20-01-2018.
 */

@Entity
public class Goal {
    @PrimaryKey(autoGenerate = true)
    public int id;
    String name;
    String description;
    boolean selected;
    int donationMoney;
    float done;
    float target;
    @Ignore
    Bitmap pic;
}
