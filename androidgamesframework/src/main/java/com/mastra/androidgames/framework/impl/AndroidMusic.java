package com.mastra.androidgames.framework.impl;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.mastra.androidgames.framework.Music;

import java.io.IOException;

public class AndroidMusic implements Music, OnCompletionListener {
	MediaPlayer mediaPlayer;
	boolean isPrepard = false;
	
	public AndroidMusic(AssetFileDescriptor assetDescriptor){
		mediaPlayer = new MediaPlayer();
		try{
			mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(),
					assetDescriptor.getStartOffset(),
					assetDescriptor.getLength());
			mediaPlayer.prepare();
			isPrepard = true;
			mediaPlayer.setOnCompletionListener(this);
		} catch (Exception e){
			throw new RuntimeException("Couldn't load music");
		}
	}
	
	@Override
	public void onCompletion(MediaPlayer arg0) {
		synchronized (this) {
			isPrepard = false;
		}
	}

	@Override
	public void play() {
		if (mediaPlayer.isPlaying())
			return;
		
		try{
			synchronized (this) {
				if (!isPrepard)
					mediaPlayer.prepare();
				mediaPlayer.start();
			}
		} catch (IllegalStateException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		mediaPlayer.stop();
		synchronized (this) {
			isPrepard = false;
		}

	}
	
	@Override
	public void pause() {
		if (mediaPlayer.isPlaying())
			mediaPlayer.pause();		
	}

	@Override
	public void setLooping(boolean looping) {
		mediaPlayer.setLooping(looping);
	}

	@Override
	public void setVolume(float volume) {
		mediaPlayer.setVolume(volume, volume);
	}

	@Override
	public boolean isPlaying() {
		return mediaPlayer.isPlaying();
	}

	@Override
	public boolean isStopped() {
		return !isPrepard;
	}

	@Override
	public boolean isLooping() {
		return mediaPlayer.isLooping();
	}

	@Override
	public void dispose() {
		if (mediaPlayer.isPlaying())
			mediaPlayer.stop();
		mediaPlayer.release();
	}

}
