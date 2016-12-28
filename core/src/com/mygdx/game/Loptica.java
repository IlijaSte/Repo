package com.mygdx.game;

public class Loptica extends Element{

	//public float x; public float y;
	//public float brzinax; public float brzinay;
	Loptica(float x, float y, float bx, float by){
		this.brzinax = bx;
		this.brzinay = by;
		this.x = x;
		this.y = y;
	}
	public void pomeri(Podloga p){

		x += brzinax;
		y += brzinay;
		
		brzinax *= 1 - (p.trenje / 100);
		brzinay *= 1 - (p.trenje / 100);
		
		//if(brzinax < 0)
		//	brzinax = 0;
		//if(brzinay < 0)
		//	brzinay = 0;
	}
	
	
	
}
