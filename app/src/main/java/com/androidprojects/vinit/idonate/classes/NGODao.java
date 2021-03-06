package com.androidprojects.vinit.idonate.classes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by ashis on 19-01-2018.
 */

@Dao
public interface NGODao {
    @Query("SELECT * FROM ngo WHERE selected = :select")
    List<NGO> getSelectedNGOs(boolean select);

    @Query("SELECT * FROM ngo")
    List<NGO> getNGOs();

    @Insert
    void insert(NGO ngo);

    @Update
    void update(List<NGO> ngos);
}
