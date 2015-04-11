package com.mastra.androidgamestudio.framework.impl;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.View.OnKeyListener;

import com.mastra.androidgamestudio.framework.Input;
import com.mastra.androidgamestudio.framework.Input.KeyEvent;
import com.mastra.androidgamestudio.framework.Pool;
import com.mastra.androidgamestudio.framework.Pool.PoolObjectFactory;

public class KeyboardHandler implements OnKeyListener {
	boolean[] pressedKeys = new boolean[128];
	Pool<Input.KeyEvent> keyEventPool;
	List<Input.KeyEvent> keyEventsBuffer = new ArrayList<Input.KeyEvent>();
	List<Input.KeyEvent> keyEvents = new ArrayList<Input.KeyEvent>();
	
	public KeyboardHandler(View view){
		PoolObjectFactory<Input.KeyEvent> factory = new PoolObjectFactory<Input.KeyEvent>(){
			public KeyEvent createObject(){
				return new KeyEvent();
			}
		};
		keyEventPool = new Pool<Input.KeyEvent>(factory, 100);
		view.setOnKeyListener(this);
		view.setFocusableInTouchMode(true);
		view.requestFocus();
	}
	
	@Override
	public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
		if (event.getAction() == android.view.KeyEvent.ACTION_MULTIPLE)
			return false;
		
		synchronized (this) {
			KeyEvent keyEvent = keyEventPool.newObject();
			keyEvent.keyCode = keyCode;
			keyEvent.keyChar = (char) event.getUnicodeChar();
			if (event.getAction() == android.view.KeyEvent.ACTION_DOWN){
				keyEvent.type = KeyEvent.KEY_DOWN;
				if (keyCode > 0 && keyCode < 127)
					pressedKeys[keyCode] = true;
			}
			if (event.getAction() == android.view.KeyEvent.ACTION_UP){
				keyEvent.type = KeyEvent.KEY_UP;
				if(keyCode > 0 && keyCode < 127)
					pressedKeys[keyCode] = false;
			}
			keyEventsBuffer.add(keyEvent);			
		}
		return false;
	}
	
	public boolean isKeyPressed(int keyCode){
		if (keyCode < 0 && keyCode > 127)
			return false;
		return pressedKeys[keyCode];
	}
	
	public List<KeyEvent> getKeyEvents(){
		synchronized (this) {
			int len = keyEvents.size();
			for (int i = 0; i < len; i++) {
				keyEventPool.free(keyEvents.get(i));
			}
			keyEvents.clear();
			keyEvents.addAll(keyEventsBuffer);
			keyEventsBuffer.clear();
			return keyEvents;
		}
	}
}
