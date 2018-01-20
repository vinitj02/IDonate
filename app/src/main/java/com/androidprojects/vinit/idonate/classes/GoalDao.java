package com.androidprojects.vinit.idonate.classes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinit on 20-01-2018.
 */

@Dao
public interface GoalDao {
    @Query("SELECT * from goal")
    ArrayList<Goal> getGoal();

    @Query("SELECT * from goal WHERE selected = :select")
    ArrayList<Goal> getSelectedGoal(boolean select);

    @Insert
    void insert(Goal goal);
}
