package com.mastra.androidgamestudio.LibraryTests;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouch.OnImageViewTouchDoubleTapListener;
import it.sephiroth.android.library.imagezoom.ImageViewTouch.OnImageViewTouchSingleTapListener;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase.OnDrawableChangeListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.mastra.androidgamestudio.R;
import com.squareup.picasso.Picasso;

public class ImageViewTestActivity extends Activity {

	private static final String LOG_TAG = "image-test";

//	ImageViewTouch mImage;
//	Button mButton1;
//	Button mButton2;
//	CheckBox mCheckBox;
	static int displayTypeCount = 0;

    @InjectView(R.id.gridview)
    GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

        ButterKnife.inject(this);

        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(ImageViewTestActivity.this, SingleImageActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

		Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();
	}

//    public static void addListeners(ImageViewTouch imageView){
//        imageView.setSingleTapListener(
//			new OnImageViewTouchSingleTapListener() {
//
//				@Override
//				public void onSingleTapConfirmed() {
//					Log.d(LOG_TAG, "onSingleTapConfirmed");
//				}
//			}
//		);
//
//        imageView.setDoubleTapListener(
//			new OnImageViewTouchDoubleTapListener() {
//
//				@Override
//				public void onDoubleTap() {
//					Log.d(LOG_TAG, "onDoubleTap");
//				}
//			}
//		);
//
//        imageView.setOnDrawableChangedListener(
//			new OnDrawableChangeListener() {
//
//				@Override
//				public void onDrawableChanged(Drawable drawable) {
//					Log.i(LOG_TAG, "onBitmapChanged: " + drawable);
//				}
//			}
//		);
//	}
}
