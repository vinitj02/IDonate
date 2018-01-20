package com.androidprojects.vinit.idonate.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.adapters.Achievements_RV;

public class Achievements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.title_activity_achievements);
        setContentView(R.layout.activity_achievements);

        //setting recycler view
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        Achievements_RV adapter=new Achievements_RV(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }
}
