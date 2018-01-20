package com.androidprojects.vinit.idonate.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidprojects.vinit.idonate.IDonate;
import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.activities.Achievements;
import com.androidprojects.vinit.idonate.classes.NGO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhav on 20/1/18.
 */

public class Achievements_RV extends RecyclerView.Adapter<Achievements_RV.holder>{
    //remove comments.. hardcodded for showcase only

    Context context;

    private List<NGO> ngos;
    public Achievements_RV(Context context){
        this.context=context;
        //ngos=((IDonate)context.getApplicationContext()).getDb().ngoDao().getNGOs();
    }


    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.activity_achievements_row,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        if (holder==null){
            holder=onCreateViewHolder(null,0);
        }
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ngo_temp));
    }

    @Override
    public int getItemCount() {
        //hardcodded for showcase only
        return 10;
        //hardcodded for showcase only
    }

    class holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        holder(View view){
            super(view);
            imageView=view.findViewById(R.id.imageView);
            textView=view.findViewById(R.id.textView);
        }
    }
}
