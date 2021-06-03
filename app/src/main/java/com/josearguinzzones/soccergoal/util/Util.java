package com.josearguinzzones.soccergoal.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.josearguinzzones.soccergoal.R;


public class Util {

    // Circular progress bar
    public static void loadImage(ImageView imageView, String url, CircularProgressDrawable progressDrawable) {

        // If it was an error on loading image use the default icon
        RequestOptions options = new RequestOptions()
                .placeholder(progressDrawable)
                .error(R.drawable.default_crest);

        // Load the url and set it for imageView
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(imageView);
        
    }

    public static CircularProgressDrawable getProgressDrawable(Context context) {
            CircularProgressDrawable cpd = new CircularProgressDrawable(context);
            cpd.setStrokeWidth(10f);
            cpd.setCenterRadius(50f);
            cpd.start();
            return cpd;
    }
}