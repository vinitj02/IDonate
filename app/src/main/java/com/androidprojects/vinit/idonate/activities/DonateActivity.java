package com.androidprojects.vinit.idonate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.Utils;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DonateActivity extends AppCompatActivity implements View.OnClickListener{

    Button nextB;
    TextView curtBalTv;
    EditText dntAmtEt;
    Long crtBalL;
    TextView payingToTv;
    CircleImageView userIM;
    CircleImageView ngoIM;
    String payingTo;
    LinearLayout transLL;
    ProgressBar transProgPB;
    TextView transMessTV;
    Long amt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_donate);

        payingTo=getIntent().getStringExtra(Utils.NGO_SELECTED);

        curtBalTv=findViewById(R.id.curtBalTV);
        dntAmtEt=findViewById(R.id.donateAmtET);
        nextB=findViewById(R.id.nextB);
        userIM=findViewById(R.id.userIM);
        ngoIM=findViewById(R.id.ngoIM);
        payingToTv=findViewById(R.id.payingToTV);
        transLL=findViewById(R.id.transLL);
        transProgPB=findViewById(R.id.transProgPB);
        transMessTV=findViewById(R.id.transMessTV);

        payingToTv.setText("Paying to "+payingTo);
        //Load with Picasso
        Picasso.with(this).load(Utils.PIC_URL+"users/"+Utils.getParamStr(this,Utils.PHONE_NO,"")+".png").networkPolicy(NetworkPolicy.OFFLINE).into(userIM);
        Picasso.with(this).load(Utils.PIC_URL+"ngos/"+payingTo+".png").networkPolicy(NetworkPolicy.OFFLINE).into(ngoIM);



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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent!=null && intent.getAction().equals(Utils.DO_TRANSACTION)){
                String passCode=intent.getStringExtra(Utils.PASS_CODE);
                transLL.setVisibility(View.VISIBLE);
                if(passCode.equals(Utils.getParamStr(this,Utils.PASS_CODE,"")))doTransaction(payingTo,amt);
                else{
                    transProgPB.setVisibility(View.GONE);
                    transMessTV.setText("Wrong PassCode");
                }
        }
    }

    @Override
    public void onClick(View view) {
        amt=Long.parseLong(dntAmtEt.getText().toString());
        if(amt>0 && amt<=crtBalL){
            startActivity(new Intent(this,PassCodeActivity.class));
        }
    }

    void doTransaction(String ngoName,Long amt){
        //TODO:Volley transaction
    }
}
