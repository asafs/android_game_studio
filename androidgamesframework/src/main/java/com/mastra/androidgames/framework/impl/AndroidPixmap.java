package com.mastra.androidgames.framework.impl;

import android.graphics.Bitmap;

import com.mastra.androidgames.framework.Graphics.PixmapFormat;
import com.mastra.androidgames.framework.Pixmap;

public class AndroidPixmap implements Pixmap {
	Bitmap bitmap;
	PixmapFormat format;
	
	public AndroidPixmap(Bitmap bitmap, PixmapFormat format){
		this.bitmap = bitmap;
		this.format = format;
	}
	
	@Override
	public int getWidth() {
		return bitmap.getWidth();
	}

	@Override
	public int getHeight() {
		return bitmap.getWidth();
	}

	@Override
	public PixmapFormat getFormat() {
		return format;
	}

	@Override
	public void dispose() {
		bitmap.recycle();
	}

}
