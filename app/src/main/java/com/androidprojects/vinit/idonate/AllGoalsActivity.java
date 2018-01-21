package com.androidprojects.vinit.idonate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class AllGoalsActivity extends AppCompatActivity {

    ArrayList<Integer> goalsSelected=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_goals);

        final GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new Adaptergoals(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,final View v,
                                    int position, long id) {
                //if(gridview.getChildAt(position)!=null) Log.e("GVC","not null "+gridview.getChildAt(position).toString());
                ImageView imageView2=(ImageView)v.findViewById(Adaptergoals.IMAGE_VIEW);
                //if(imageView2!=null)Log.e("IV2","not null");
                if(imageView2.getVisibility()==View.INVISIBLE)
                {
                    imageView2.setVisibility(View.VISIBLE);
                    goalsSelected.add(position);
                }
                else
                {
                    AlertDialog.Builder myDialog = new AlertDialog.Builder(AllGoalsActivity.this);
                    myDialog.setTitle("");
                    myDialog.setMessage("On clicking OK, all the progress of this goal will be lost.\nAre you sure if you want to proceed?");
                    myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            v.findViewById(Adaptergoals.IMAGE_VIEW).setVisibility(View.INVISIBLE);
                        } });
                    myDialog.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        } });
                    myDialog.show();
                    goalsSelected.remove(new Integer(position));
                }
            }
        });
    }


}
