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

public class Adaptergoals extends BaseAdapter {

    private Context mContext;
    static public int IMAGE_VIEW=789711;

    public Adaptergoals(Context c) {
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
        ImageView imageView2,imageView;

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
           cardView=(CardView) ((Activity)mContext).getLayoutInflater().inflate(R.layout.goal,null);
            imageView=(ImageView)cardView.findViewById(R.id.imageView);
            imageView2 = new ImageView(mContext);
            imageView2.setLayoutParams(new ViewGroup.LayoutParams(CardView.LayoutParams.WRAP_CONTENT,CardView.LayoutParams.WRAP_CONTENT));
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView2.setVisibility(View.INVISIBLE);
            imageView2.setId(IMAGE_VIEW);
            cardView.addView(imageView2);
        } else {

            cardView = (CardView) convertView;
            imageView=(ImageView)cardView.findViewById(R.id.imageView);
            imageView2=(ImageView)cardView.findViewById(IMAGE_VIEW);
        }
        //imageView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        imageView.setImageResource(mThumbIds[position]);
        imageView2.setImageResource(R.drawable.ic_check_circle_black_24dp);
        return cardView;
    }

    // references to our images
    private Integer[] mThumbIds = {//change the drawables to NGO photos
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1,
            R.drawable.goal1, R.drawable.goal1
    };
}
