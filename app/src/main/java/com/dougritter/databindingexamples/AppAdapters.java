package com.dougritter.databindingexamples;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class AppAdapters {
    public static final String TAG = AppAdapters.class.getSimpleName();

    @BindingAdapter(value = {"android:src", "placeHolder"}, requireAll = false)
    public static void setImageUrl(ImageView view, String url, int placeHolder) {
        RequestCreator requestCreator = Picasso.with(view.getContext())
                .load(url)
                .fit();

        if (placeHolder != 0) {
            requestCreator.placeholder(placeHolder);
        }

        requestCreator.into(view);
    }

}
