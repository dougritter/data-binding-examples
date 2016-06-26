package com.dougritter.databindingexamples;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class ImageUtil {

    public static final String TAG = ImageUtil.class.getSimpleName();

    /*@BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .fit()
                .into(view);
    }
*/

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
