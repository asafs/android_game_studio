package com.mastra.androidgamestudio.LibraryTests;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.mastra.androidgamestudio.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class SingleImageActivity extends ActionBarActivity {
    @InjectView(R.id.image)
    ImageView imageViewTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_image);

        ButterKnife.inject(this);
        int position = getIntent().getIntExtra("position", -1);
        if (position != -1){
            Picasso.with(this)
                    .load(ImageAdapter.mThumbURLs[position])
                    .placeholder(R.mipmap.placeholder)
                    .noFade()
                    .resize(800,800)
                    .centerCrop()
                    .into(imageViewTouch);
        } else {
            Picasso.with(this)
                    .load(R.mipmap.placeholder)
                    .noFade()
                    .resize(800,800)
                    .centerCrop()
                    .into(imageViewTouch);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
