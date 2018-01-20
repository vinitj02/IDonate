package com.androidprojects.vinit.idonate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidprojects.vinit.idonate.IDonate;
import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.Utils;
import com.androidprojects.vinit.idonate.classes.NGO;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.List;

public class ChooseNgoActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView ngosRv;
    Button donateB;
    Button viewAllB;
    NgosAdapter adapter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ngo);
        ngosRv=(RecyclerView)findViewById(R.id.ngosRV);
        donateB=(Button)findViewById(R.id.donateB);
        viewAllB=(Button)findViewById(R.id.viewAllB);

        adapter=new NgosAdapter(((IDonate)getApplication()).getDb().ngoDao().getSelectedNGOs(true));

        donateB.setOnClickListener(this);

        ngosRv.setLayoutManager(new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false));
        ngosRv.setAdapter(adapter);

        viewAllB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.setNgos(((IDonate)getApplication()).getDb().ngoDao().getNGOs());
            }
        });

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,DonateActivity.class).putExtra(Utils.NGO_SELECTED,adapter.ngos.get(adapter.selected).name));
    }

    class NgosAdapter extends RecyclerView.Adapter<NgosAdapter.HolderView>{
        List<NGO> ngos;
        int selected=-1;

        public NgosAdapter(List<NGO> ngos){
            this.ngos=ngos;
        }

        public void setNgos(List<NGO> ngos){
            this.ngos=ngos;
            selected=-1;
            notifyDataSetChanged();
        }

        class HolderView extends RecyclerView.ViewHolder{
            TextView name;
            DonutProgress progress;
            TextView goal;
            ImageView selected;
            public HolderView(View itemView) {
                super(itemView);
                name=(TextView)itemView.findViewById(R.id.ngoNameTV);
                progress=(DonutProgress)itemView.findViewById(R.id.progressDP);
                goal=(TextView)itemView.findViewById(R.id.goalTV);
                selected=(ImageView)itemView.findViewById(R.id.selectedIM);
            }
        }

        @Override
        public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HolderView(View.inflate(parent.getContext(),R.layout.donate_ngo,null));
        }

        @Override
        public void onBindViewHolder(HolderView holder, final int position) {
            NGO ngo=ngos.get(position);
            holder.name.setText(ngo.name);
            holder.goal.setText("\u20B9 "+ngo.target);
            holder.progress.setProgress((float)ngo.donated/ngo.target);
            holder.progress.setText(((int)((float)ngo.donated/ngo.target))+"%");
            if(selected==position)holder.selected.setVisibility(View.VISIBLE);
            else holder.selected.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selected==position){
                        selected=-1;
                        notifyItemChanged(position);
                        donateB.setEnabled(false);
                    }
                    else{
                        int prevSel=selected;
                        selected=position;
                        if(prevSel!=-1){
                            notifyItemChanged(prevSel);
                        }
                        notifyItemChanged(position);
                        donateB.setEnabled(true);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return ngos==null?0:ngos.size();
        }
    }
}
