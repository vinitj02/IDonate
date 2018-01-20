package com.androidprojects.vinit.idonate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.Utils;
import com.chaos.view.PinView;

public class UpiActivity extends AppCompatActivity implements View.OnClickListener{

    PinView upiPV;
    Button proceedB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        upiPV=(PinView)findViewById(R.id.upiPV);
        proceedB=(Button)findViewById(R.id.proceesB);

        proceedB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String str= upiPV.getText().toString();
        if(str.length()==6)startActivity(new Intent(this,DonateActivity.class).setAction(Utils.DO_TRANSACTION).putExtra(Utils.UPI_CODE,str));
    }
}
