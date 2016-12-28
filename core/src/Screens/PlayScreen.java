package Screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Blok;
import com.mygdx.game.Element;
import com.mygdx.game.Loptica;
import com.mygdx.game.Podloga;
import com.mygdx.game.TheBalls;

public class PlayScreen implements Screen {

	private TheBalls game;
	private OrthographicCamera gameCam;
	private Viewport gameView;
	private float offset = 20;
	private float objScale = 40;
	Texture post1Text;
	Texture ballText;
	Texture blokText;
	Element l;
	Element blok;
	Podloga p;
	ArrayList<Element> arr;
	
	public PlayScreen(TheBalls game){
		this.game = game;
		
		gameCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		gameCam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game.batch.setProjectionMatrix(gameCam.combined);
		game.shapeRend.setProjectionMatrix(gameCam.combined);
		gameView = new FitViewport(640, 480, gameCam);
		
		
		post1Text = new Texture("postolje.jpg");
		ballText = new Texture("pinball2.png");
		blokText = new Texture("blok.png");
		l = new Loptica(offset, offset, 10, 0, ballText);
		blok = new Blok(gameView.getWorldWidth() - offset - objScale, offset, blokText);
		p = new Podloga(post1Text, 1.3f);
		arr = new ArrayList<Element>();
		arr.add(l);
		arr.add(blok);
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.justTouched()){
			
			
			arr.add(new Blok(Math.round(Gdx.input.getX() / objScale) * objScale - objScale / 2, Math.round(Gdx.input.getY() / objScale) * objScale - objScale / 2, blokText));
			
		}
		
		game.batch.begin();
		game.batch.draw(p.text, 0, 0);
		
		for(int i = 0; i < arr.size(); i++){
			game.batch.draw(arr.get(i).getText(), arr.get(i).getX(), arr.get(i).getY(), objScale, objScale);
		}
		l.pomeri(p);
		l.proveriKol(arr);

		game.batch.end();
		
		double drawX = Math.round(Gdx.input.getX() / objScale) * objScale - objScale / 2;
		double drawY = Math.round(Gdx.input.getY() / objScale) * objScale - objScale / 2;
		Gdx.gl.glEnable(GL20.GL_BLEND);
		
		game.shapeRend.begin(ShapeType.Filled);
		game.shapeRend.setColor(0, 0, 1, 0.6f);
		game.shapeRend.rect((float)drawX, (float)drawY, objScale, objScale);
		game.shapeRend.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		gameView.update(width, height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		post1Text.dispose();
		ballText.dispose();
	}
	
}
