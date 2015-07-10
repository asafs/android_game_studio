package com.mastra.androidgamestudio.LibraryTests;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.mastra.androidgamestudio.R;
import com.squareup.picasso.Picasso;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * Created by Asaf on 22/4/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbURLs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageViewTouch;
        if (convertView == null){
            imageViewTouch = new ImageView(mContext);
//            imageViewTouch.setLayoutParams(new GridView.LayoutParams(85, 85));
//            imageViewTouch.setScaleType(ImageViewTouch.ScaleType.CENTER_CROP);
//            imageViewTouch.setPadding(8, 8, 8, 8);
        } else {
            imageViewTouch = (ImageView) convertView;
        }

//        ImageViewTestActivity.addListeners(imageViewTouch);

        Picasso.with(mContext)
                .load(mThumbURLs[position])
                .resize(300, 300)
                .placeholder(R.mipmap.placeholder)
                .into(imageViewTouch);
        return imageViewTouch;
    }

    public static String[] mThumbURLs = {
            "http://i.imgur.com/DvpvklR.png",
            "http://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png",
            "http://www.libpng.org/pub/png/img_png/pnglogo-blk.jpg",
            "http://th02.deviantart.net/fs70/PRE/f/2010/171/4/0/Paint_Splash_PNG_by_AbsurdWordPreferred.png"
    };
}
