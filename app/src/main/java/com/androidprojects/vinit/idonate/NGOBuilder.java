package com.androidprojects.vinit.idonate;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Vinit on 16-01-2018.
 */

public class NGOBuilder {

    public static CardView[] ngocardbuilder(Context context, int px) {
        int no_of_cards = 4;
        // Initialize a new CardView array
        CardView[] cardViews = new CardView[4];//Change the number of cards when you link with database

        if (no_of_cards == 0) {
            return null;
        }
        else {

            for (int i = 0; i < no_of_cards; i++) {//Also change number of cards in this line

                CardView card = new CardView(context);
                // Set the CardView layoutParams
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params.setMargins(px, 0, px, px);
                card.setLayoutParams(params);

                // Set CardView corner radius
                card.setRadius(px / 2);

                // Set the CardView maximum elevation
                card.setMaxCardElevation(15);

                // Set CardView elevation
                card.setCardElevation(9);

                //Card background
                card.setCardBackgroundColor(Color.parseColor("#3F51B5"));

                //Create Vertical Linear Layout
                LinearLayout linearLayout1 = new LinearLayout(context);
                linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                linearLayout1.setOrientation(LinearLayout.VERTICAL);

                //Create TextView
                TextView textView = new TextView(context);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 2f);
                params1.setMargins(px / 2, px / 2, px / 2, 0);
                textView.setLayoutParams(params1);
                textView.setText("Women and Child Care NGO\n\n \u20B9300 of \u20B91000");
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.WHITE);


                ProgressBar progressBar = new ProgressBar(context);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f);
                progressBar.setLayoutParams(params2);
                progressBar.setIndeterminate(false);

                linearLayout1.addView(textView);
                linearLayout1.addView(progressBar);

                card.addView(linearLayout1);
                cardViews[i] = card;
            }
            return cardViews;
        }
    }
}

