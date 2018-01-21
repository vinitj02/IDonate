package com.androidprojects.vinit.idonate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vinit on 19-01-2018.
 */

public class Adapter extends BaseAdapter{

    static public int IMAGE_VIEW=789798,IMAGE_VIEW2=33111;

    private Context mContext;

    public Adapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        CardView cardView;
        ImageView imageView,imageView2;
        TextView textView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;
            int dimension=java.lang.Math.min(height, width);
            cardView=new CardView(mContext);
            GridView.LayoutParams params1=new GridView.LayoutParams((int)(dimension/2.1),(int)(dimension/2.1));
            cardView.setLayoutParams(params1);
            // Set CardView corner radius
            cardView.setRadius(Utils.getPx(mContext,4));
            // Set the CardView maximum elevation
            cardView.setMaxCardElevation(15);
            // Set CardView elevation
            cardView.setCardElevation(9);
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(CardView.LayoutParams.MATCH_PARENT,CardView.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView2 = new ImageView(mContext);
            imageView2.setLayoutParams(new ViewGroup.LayoutParams(CardView.LayoutParams.WRAP_CONTENT,CardView.LayoutParams.WRAP_CONTENT));
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView2.setVisibility(View.INVISIBLE);
            //imageView.setPadding(8, 8, 8, 8);
            textView=new TextView(mContext);
            CardView.LayoutParams params=new FrameLayout.LayoutParams(CardView.LayoutParams.WRAP_CONTENT,CardView.LayoutParams.WRAP_CONTENT);
            params.gravity=Gravity.CENTER;
            textView.setLayoutParams(params);
            textView.setText("NGO");
            textView.setTextColor(Color.parseColor("#3F51B5"));
            TextView textView2=new TextView(mContext);
            CardView.LayoutParams params2=new FrameLayout.LayoutParams(CardView.LayoutParams.WRAP_CONTENT,CardView.LayoutParams.WRAP_CONTENT);
            params2.gravity=Gravity.RIGHT|Gravity.BOTTOM;
            params2.bottomMargin=Utils.getPx(mContext,2);
            params2.rightMargin=Utils.getPx(mContext,2);
            textView2.setLayoutParams(params2);
            textView2.setText("Details");
            textView2.setTextColor(Color.parseColor("#3F51B5"));
            textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            textView2.setClickable(true);
            TextView.OnClickListener onClickListener=new TextView.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder myDialog = new AlertDialog.Builder(mContext);
                    myDialog.setTitle("NGO");
                    myDialog.setView(R.layout.alertdialogngos);
                    myDialog.setPositiveButton("Back", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        } });
                    myDialog.show();
                }
            };
            textView2.setOnClickListener(onClickListener);
            cardView.addView(imageView);
            cardView.addView(textView);
            cardView.addView(imageView2);
            cardView.addView(textView2);
            imageView.setId(IMAGE_VIEW);
            imageView2.setId(IMAGE_VIEW2);
        } else {
            cardView = (CardView) convertView;
            imageView=(ImageView)cardView.findViewById(IMAGE_VIEW);
            imageView2=(ImageView)cardView.findViewById(IMAGE_VIEW2);
        }
        imageView.setImageResource(mThumbIds[position]);
        imageView2.setImageResource(R.drawable.ic_check_circle_black_24dp);
        //imageView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        return cardView;
    }

    // references to our images
    private Integer[] mThumbIds = {//change the drawables to NGO photos
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2,
            R.drawable.ngo_sample2, R.drawable.ngo_sample2
    };
}
