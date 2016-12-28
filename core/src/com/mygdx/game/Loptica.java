package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Loptica extends Element{


	public Loptica(float x, float y, float bx, float by, Texture t){
		this.brzinax = bx;
		this.brzinay = by;
		this.x = x;
		this.y = y;
		text = t;
	}
	public void pomeri(Podloga p){

		x += brzinax;
		y += brzinay;
		
		brzinax *= 1 - (p.trenje / 100);
		brzinay *= 1 - (p.trenje / 100);
		
	}
	
	
	
}
