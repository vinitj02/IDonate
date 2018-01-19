package com.androidprojects.vinit.idonate.activities;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.Utils;
import com.firebase.ui.auth.util.GoogleApiHelper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ashis on 18-01-2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText phoneNoEt;
    Button continueB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        phoneNoEt=(EditText) findViewById(R.id.phoneNoET);
        continueB=(Button)findViewById(R.id.continueB);

        continueB.setOnClickListener(this);

        HintRequest hintRequest = new HintRequest.Builder()
                .setHintPickerConfig(new CredentialPickerConfig.Builder().setShowCancelButton(true).build())
                .setPhoneNumberIdentifierSupported(true)
                .build();

        GoogleApiClient apiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.CREDENTIALS_API).enableAutoManage(this, GoogleApiHelper.getSafeAutoManageId(), new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.e("GAC Error:", "Client connection failed: " + connectionResult.getErrorMessage());
                    }
                }).build();


        PendingIntent intent = Auth.CredentialsApi.getHintPickerIntent(
                apiClient, hintRequest);

        try {startIntentSenderForResult(intent.getIntentSender(), Utils.PHONE_HINT, null, 0, 0, 0);}catch (Exception e){}



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Utils.PHONE_HINT) {
            if (data != null) {
                Credential cred = data.getParcelableExtra(Credential.EXTRA_KEY);
                if (cred != null) {
                    final String unformattedPhone = cred.getId();
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        String phoneNoStr=phoneNoEt.getText().toString();
        if(phoneNoStr.length()==10){
            submitNo(Long.parseLong(phoneNoStr));
        }
    }


    void submitNo(Long no){

    }
}
