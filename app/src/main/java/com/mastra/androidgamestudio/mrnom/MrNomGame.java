package com.mastra.androidgamestudio.mrnom;


import com.mastra.androidgames.framework.Screen;
import com.mastra.androidgames.framework.impl.AndroidGame;

public class MrNomGame extends AndroidGame {

	@Override
	public Screen getStartScreen() {
		return new LoadingScreen(this);
	}

}
