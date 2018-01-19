package com.androidprojects.vinit.idonate.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.Utils;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class OTPActivity extends AppCompatActivity implements View.OnClickListener{

    EditText otpEt;
    Button verifyB;
    BroadcastReceiver otpReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otp);
        otpEt=(EditText)findViewById(R.id.otpET);
        verifyB=(Button)findViewById(R.id.verifyB);
        otpEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length()>0)verifyB.setEnabled(true);
                else verifyB.setEnabled(false);
            }
        });

        verifyB.setOnClickListener(this);

        otpReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(Utils.OTP_RECEIVED)){
                    otpEt.setText(intent.getStringExtra(Utils.OTP));
                    verifyB.performClick();
                }
            }
        };

        SmsRetrieverClient client = SmsRetriever.getClient(this);
        Task<Void> task = client.startSmsRetriever();
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {}});

        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("SMS_RETRIEVE","Failed to start retriever");
            }});
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(otpReceiver,new IntentFilter(Utils.OTP_RECEIVED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(otpReceiver);
    }

    @Override
    public void onClick(View view) {
        String str=otpEt.getText().toString();
        if(str.length()!=0){submitOtp(str);}
    }

    void submitOtp(String otp){
        //TODO:verify otp
    }
}
