package com.androidprojects.vinit.idonate;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidprojects.vinit.idonate.activities.Achievements;
import com.androidprojects.vinit.idonate.activities.LoginActivity;
import com.firebase.ui.auth.util.GoogleApiHelper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CardView[] cardViews;
    ConstraintLayout[] NGOcardViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long id=Utils.getParamL(this,Utils.LOGIN_ID,0);

       // if(id==0)startActivity(new Intent(this, LoginActivity.class));



        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Convert dp to px to use in functions
        Resources r = getResources();
        int px = Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 8, r.getDisplayMetrics()));

        //horizontal linear layout
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);

        //horizontal scroll views
        HorizontalScrollView horizontalScrollView=(HorizontalScrollView)findViewById(R.id.horizontalscroll1);
        HorizontalScrollView horizontalScrollView1=(HorizontalScrollView)findViewById(R.id.horizontalscroll2);

        //Buttons
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button_addgoals);
        Button button4=(Button)findViewById(R.id.button_addngos);

        cardViews = GoalsBuilder.cardbuilder(MainActivity.this, px);
        if(cardViews==null)
        {
            button1.setVisibility(View.GONE);
            horizontalScrollView.setVisibility(View.GONE);
        }

        else {

            button3.setVisibility(View.GONE);
            for (int i = 0; i < 4; i++)//change the number of cards according to goals in database
            {
                linearLayout.addView(cardViews[i]);
            }
        }

        //horizontal linear layout
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearlayout2);

        NGOcardViews = NGOBuilder.ngocardbuilder(MainActivity.this, px);

        if(NGOcardViews==null)
        {
            button2.setVisibility(View.GONE);
            horizontalScrollView1.setVisibility(View.GONE);
        }

        else {
            button4.setVisibility(View.GONE);
            for (int i = 0; i < 4; i++)//change the number of cards according to goals in database
            {
                linearLayout2.addView(NGOcardViews[i]);
            }
        }
    }

    public void SelectNGOs(View view)
    {
        if(NGOcardViews==null)
        {
            Intent intent=new Intent(MainActivity.this,AllNGOsActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.achievement) {
            startActivity(new Intent(this, Achievements.class));
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
