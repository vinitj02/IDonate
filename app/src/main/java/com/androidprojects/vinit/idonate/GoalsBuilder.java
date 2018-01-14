package com.androidprojects.vinit.idonate;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Vinit on 15-01-2018.
 */

public class GoalsBuilder {

    //Get Details of Goal Cards from Database and store it in Goal objects

   public static CardView cardbuilder(Context context,int px)
   {
       // Initialize a new CardView
       CardView card = new CardView(context);
       // Set the CardView layoutParams
       LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
       params.setMargins(px,px,px,px);
       card.setLayoutParams(params);

       // Set CardView corner radius
       card.setRadius(px/2);

       // Set the CardView maximum elevation
       card.setMaxCardElevation(15);

       // Set CardView elevation
       card.setCardElevation(9);

       //Create Vertical Linear Layout
       LinearLayout linearLayout1= new LinearLayout(context);
       linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
       linearLayout1.setOrientation(LinearLayout.VERTICAL);

       //Create ImageView
       ImageView imageView=new ImageView(context);
       //setting image resource
       imageView.setImageResource(R.drawable.ic_launcher_background);
       //setting image position
       LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
               0,2f);
       params1.setMargins(0,px,0,0);
       imageView.setLayoutParams(params1);

       //Create TextView
       TextView textView=new TextView(context);
       LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1f);
       params2.setMargins(px/2,px/2,px/2,0);
       textView.setLayoutParams(params2);
       textView.setText("Run 5 km.\nin 5 days");
       textView.setGravity(Gravity.CENTER);

       linearLayout1.addView(imageView);
       linearLayout1.addView(textView);

       card.addView(linearLayout1);

       return card;
   }
}
