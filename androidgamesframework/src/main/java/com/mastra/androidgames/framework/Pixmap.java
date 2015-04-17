package com.mastra.androidgames.framework;

import com.mastra.androidgames.framework.Graphics.PixmapFormat;

public interface Pixmap {
	public int getWidth();
	public int getHeight();
	public PixmapFormat getFormat();
	public void dispose();
}
