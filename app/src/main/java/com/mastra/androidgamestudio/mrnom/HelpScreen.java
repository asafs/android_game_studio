package com.mastra.androidgamestudio.mrnom;

import java.util.List;

import com.mastra.androidgames.framework.Graphics;
import com.mastra.androidgames.framework.Input.TouchEvent;
import com.mastra.androidgames.framework.Game;
import com.mastra.androidgames.framework.Screen;

public class HelpScreen extends Screen {

	public HelpScreen(Game game){
		super(game);
	}
	
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		
		for (int i = 0; i < touchEvents.size(); i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP){
				if (event.x > 256 && event.y > 416){
					game.setScreen(new HelpScreen2(game));
					if (Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
		g.drawPixmap(Assets.help1, 64, 100);
		g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}

}
