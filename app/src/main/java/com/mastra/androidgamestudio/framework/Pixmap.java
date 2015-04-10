package com.mastra.androidgamestudio.framework;

import com.mastra.androidgamestudio.framework.Graphics.PixmapFormat;

public interface Pixmap {
	public int getWidth();
	public int getHeight();
	public PixmapFormat getFormat();
	public void dispose();
}
