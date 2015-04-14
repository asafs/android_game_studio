package com.mastra.androidgamestudio.mrnom;


import com.mastra.androidgamestudio.framework.Screen;
import com.mastra.androidgamestudio.framework.impl.AndroidGame;

public class MrNomGame extends AndroidGame {

	@Override
	public Screen getStartScreen() {
		return new LoadingScreen(this);
	}

}
