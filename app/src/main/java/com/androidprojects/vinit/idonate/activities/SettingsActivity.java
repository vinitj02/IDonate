package com.androidprojects.vinit.idonate.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.androidprojects.vinit.idonate.R;
import com.androidprojects.vinit.idonate.Utils;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    EditText donationLimitET;
    Spinner nearestS;
    RecyclerView cardsRV;
    Button addCardsB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        donationLimitET=findViewById(R.id.donationLimitET);
        nearestS=findViewById(R.id.nearestS);
        cardsRV=findViewById(R.id.cardsRV);
        addCardsB=findViewById(R.id.addCardB);

        int nearestI=Utils.getParamI(this,Utils.NEAREST,10);
        int pos=-1;
        while ((nearestI/=10)>0)pos++;

        donationLimitET.setText(String.valueOf(Utils.getParamL(this,Utils.DONATION_LIMIT,0)));
        nearestS.setSelection(pos);
        cardsRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //cardsRV.setAdapter();
        addCardsB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        int near=nearestS.getSelectedItemPosition();
        int nearest=10;
        while (near-- > 1)nearest*=10;
        Utils.setParamL(this,Utils.DONATION_LIMIT,Long.parseLong(donationLimitET.getText().toString()));
        Utils.setParamI(this,Utils.NEAREST,nearest);
        //update Donation Limit
    }
}
