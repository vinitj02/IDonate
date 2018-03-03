package com.androidprojects.vinit.idonate.activities;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidprojects.vinit.idonate.IDonate;
import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.classes.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TransactionsActivity extends AppCompatActivity {

    RecyclerView transactionsRV;
    TextView emptyTV;
    TransactionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        emptyTV=findViewById(R.id.emptyTV);
        transactionsRV=findViewById(R.id.transactions_RV);
        adapter=new TransactionsAdapter();
        transactionsRV.setAdapter(adapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<Transaction> transactions=((IDonate)getApplication()).getDb().transactionDao().getTransactions();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setTransactions(transactions);
                    }
                });
            }
        }).start();
    }

    public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.HolderView>{

        public ArrayList<Transaction> transactions=null;

        public void setTransactions(ArrayList<Transaction> transactions){
            this.transactions=transactions;
            if(transactions.size()==0){
                transactionsRV.setVisibility(View.GONE);
                emptyTV.setVisibility(View.VISIBLE);
            }
            else{
                transactionsRV.setVisibility(View.VISIBLE);
                emptyTV.setVisibility(View.GONE);
            }
            notifyDataSetChanged();
        }

        public class HolderView extends RecyclerView.ViewHolder{
            public TextView amount;
            public TextView to;
            public TextView time;
            public HolderView(View itemView) {
                super(itemView);
                amount=itemView.findViewById(R.id.amountTV);
                to=itemView.findViewById(R.id.toTV);
                time=itemView.findViewById(R.id.timeTV);
            }
        }

        @Override
        public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HolderView(LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction,null));
        }

        @Override
        public void onBindViewHolder(HolderView holder, int position) {
            Transaction transaction=transactions.get(position);
            holder.amount.setText("\u20B9 "+transaction.amount);
            holder.to.setText(transaction.to);
            String time="";
            if(isSameDay(transaction.time,new Date())){//check if the date is of today
                SimpleDateFormat format=new SimpleDateFormat("hh:mm");
                time=format.format(transaction.time);
            }
            else if(isSameDay(transaction.time,new Date(new Date().getTime()-(24*60*60*1000)))){
                time="YESTERDAY";
            }
            else{
                SimpleDateFormat format=new SimpleDateFormat("dd:MM:yy");
                time=format.format(transaction.time);
            }
            holder.time.setText(time);
        }

        @Override
        public int getItemCount() {
            return transactions==null?0:transactions.size();
        }

        public boolean isSameDay(Date d1,Date d2){
            Calendar cal1=Calendar.getInstance();
            Calendar cal2=Calendar.getInstance();
            cal1.setTime(d1);cal2.setTime(d2);
            return (cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR))&&
                    (cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH))&&
                    (cal1.get(Calendar.DAY_OF_MONTH)==cal2.get(Calendar.DAY_OF_MONTH));
        }
    }

}