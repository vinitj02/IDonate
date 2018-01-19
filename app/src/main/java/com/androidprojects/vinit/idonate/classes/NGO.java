package com.androidprojects.vinit.idonate.classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

@Entity
public class NGO {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    boolean selected;
    int donated;
    int target;
    @Ignore
    Bitmap pic;
}
