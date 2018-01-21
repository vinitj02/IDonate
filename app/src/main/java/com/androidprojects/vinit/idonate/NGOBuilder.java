package com.androidprojects.vinit.idonate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidprojects.vinit.idonate.classes.NGO;

import java.util.List;

/**
 * Created by Vinit on 16-01-2018.
 */

public class NGOBuilder {

    public static ConstraintLayout[] ngocardbuilder(View v, int px) {
        //List<NGO> selectedngos = ((IDonate)v.getContext().getApplicationContext()).getDb().ngoDao().getSelectedNGOs(true);
        //int no_of_cards=selectedngos.size();
        int no_of_cards=0;
        // Initialize a new CardView array
        ConstraintLayout[] constraintLayouts = new ConstraintLayout[no_of_cards];

        if (no_of_cards == 0) {
            return null;
        }
        else {

            for (int i = 0; i < no_of_cards; i++) {//Also change number of cards in this line
                Log.e("mKIBNG",i+"");
                ConstraintLayout constraintLayout=(ConstraintLayout) LayoutInflater.from(v.getContext()).inflate(R.layout.ngocard,null);
                constraintLayouts[i] = constraintLayout;
            }
            return constraintLayouts;
        }
    }
}

