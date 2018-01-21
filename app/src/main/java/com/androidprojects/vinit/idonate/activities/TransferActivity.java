package com.androidprojects.vinit.idonate.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidprojects.vinit.idonate.Utils;

public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean dnt=getIntent().getBooleanExtra(Utils.DONATE,false);
        if(dnt){
            long amt=getIntent().getLongExtra(Utils.DONATION_AMOUNT,0);
            doTransaction(amt);
        }
    }

    void doTransaction(long amt){
        Utils.setParamL(this,Utils.CURRENT_BALANCE,Utils.getParamL(this,Utils.CURRENT_BALANCE,0)+amt);
    }

}
