package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class TestGame extends ApplicationAdapter {

	SpriteBatch batch;
	Texture post1Text;
	Texture ballText;
	Texture blokText;
	Element l = new Loptica(16, 420, 10, 0);
	Element blok = new Blok(580, 420);
	Podloga p;
	ArrayList<Element> arr;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		post1Text = new Texture("postolje.jpg");
		ballText = new Texture("pinball2.png");
		blokText = new Texture("blok.png");
		p = new Podloga(post1Text, 1.3f);
		arr = new ArrayList<Element>();
		arr.add(l);
		arr.add(blok);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(p.text, 0, 0);
		batch.draw(ballText, l.x, l.y, 42, 42);
		batch.draw(blokText, blok.x, blok.y, 42, 42);
		l.pomeri(p);
		l.proveriKol(arr);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		post1Text.dispose();
		ballText.dispose();
	}
}
