package com.androidprojects.vinit.idonate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.Utils;

public class DonateActivity extends AppCompatActivity implements View.OnClickListener{

    Button nextB;
    TextView curtBalTv;
    EditText dntAmtEt;
    Long crtBalL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_donate);
        curtBalTv=(TextView)findViewById(R.id.curtBalTV);
        dntAmtEt=(EditText)findViewById(R.id.donateAmtET);
        nextB=(Button)findViewById(R.id.nextB);

        dntAmtEt.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()>0)nextB.setEnabled(true);
                else nextB.setEnabled(false);
            }
        });

        crtBalL=Utils.getParamL(this,Utils.CURRENT_BALANCE,0);
        String crtBal="Current Balance\n\u20B9 "+ crtBalL;
        curtBalTv.setText(crtBal);

        dntAmtEt.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        String amt=dntAmtEt.getText().toString();
        if(amt.length()>0 && Long.parseLong(amt)<=crtBalL){
            startActivity(new Intent(this,ChooseNgoActivity.class).putExtra(Utils.DONATION_AMOUNT,Long.parseLong(amt)));
        }
    }

    void doTransaction(String upiCode){

    }
}
