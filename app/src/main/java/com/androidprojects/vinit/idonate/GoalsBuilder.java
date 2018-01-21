package com.androidprojects.vinit.idonate;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

/**
 * Created by Vinit on 15-01-2018.
 */

public class GoalsBuilder {

    //Get Details of Goal Cards from Database and store it in Goal objects
   public static CardView[] cardbuilder(Context context,int px)
   {
       int no_of_cards=4;
       // Initialize a new CardView array
       CardView[] cardViews=new CardView[no_of_cards];//Change the number of cards when you link with database

       if(no_of_cards==0)
       {
           return null;
       }
       else
       {
           for(int i=0;i<no_of_cards;i++) {//Also change number of cards in this line

               CardView card = new CardView(context);
               // Set the CardView layoutParams
               LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
               params.setMargins(px, px, px, px);
               card.setLayoutParams(params);

               // Set CardView corner radius
               card.setRadius(px / 2);

               // Set the CardView maximum elevation
               card.setMaxCardElevation(15);

               // Set CardView elevation
               card.setCardElevation(9);

               //Create Vertical Linear Layout
               LinearLayout linearLayout1 = new LinearLayout(context);
               int size=Utils.getPx(linearLayout1.getContext(),32);
               linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
               linearLayout1.setOrientation(LinearLayout.VERTICAL);

               //Create ImageView
               ImageView imageView = new ImageView(context);
               //setting image resource
               imageView.setImageResource(R.drawable.goal1);
               //setting image position
               LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       0, 2.5f);
               params1.setMargins(0, px, 0, 0);
               imageView.setLayoutParams(params1);

               //Create TextView
               TextView textView = new TextView(context);
               LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 0, 1.5f);
               params2.setMargins(px / 2, px / 2, px / 2, 0);
               textView.setLayoutParams(params2);
               textView.setText("Run 5 km. in 5 days\n \u20B9300");
               textView.setGravity(Gravity.CENTER);

               DonutProgress progressBar=new DonutProgress(context);
               LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(size, size, 0);
               params3.gravity=Gravity.CENTER;
               progressBar.setUnfinishedStrokeWidth(size/16);
               progressBar.setFinishedStrokeWidth(size/8);
               progressBar.setLayoutParams(params3);
               progressBar.setShowText(false);

               linearLayout1.addView(imageView);
               linearLayout1.addView(textView);
               linearLayout1.addView(progressBar);

               card.addView(linearLayout1);
               cardViews[i]=card;
           }
           return cardViews;
       }

   }
}
