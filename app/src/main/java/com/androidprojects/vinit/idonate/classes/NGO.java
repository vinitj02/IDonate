package com.androidprojects.vinit.idonate.classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

@Entity
public class NGO {
    @PrimaryKey(autoGenerate = true)
    private int id;
    public String name;
    public boolean selected;
    public int donated;
    public int target;
    @Ignore
    public Bitmap pic;
}
