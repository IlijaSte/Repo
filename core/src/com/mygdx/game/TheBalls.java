package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import Screens.PlayScreen;
public class TheBalls extends Game {

	
	public SpriteBatch batch;
	public ShapeRenderer shapeRend;
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRend = new ShapeRenderer();
		setScreen(new PlayScreen(this));	
		
	}

	@Override
	public void render () {
		super.render();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
