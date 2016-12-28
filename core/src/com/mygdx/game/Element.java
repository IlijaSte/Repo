package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public abstract class Element {
	
	protected float x; protected float y;
	protected float brzinax; protected float brzinay;
	protected Texture text;
	
	public abstract void pomeri(Podloga p);
   
    public Texture getText(){
    	return text;
    }
	
    public float getX(){
    	return x;
    }
    
    public float getY(){
    	return y;
    }
    
    public float getSpeedX(){
    	return brzinax;
    }
    public float getSpeedY(){
    	return brzinay;
    }
    
    public boolean proveriKol(ArrayList<Element> arr){
    	for(int i = 0; i < arr.size(); i++){
    		if(arr.get(i) != this){
    			if((Math.abs(arr.get(i).x - (this.x + 40)) < Math.abs(brzinax)) && (Math.abs(arr.get(i).y - this.y) < 40)){
    				brzinax *= (-1);
    				brzinax *= 0.4f;
    				return true;
    			}
    			if(((Math.abs((arr.get(i).x + 40) - this.x)) < Math.abs(brzinax)) && (Math.abs(arr.get(i).y - this.y) < 40)){
    				//System.out.println(x);
    				brzinax *= (-1);
    				brzinax *= 0.4f;
    				return true;
    			}
    			if((Math.abs(arr.get(i).y - (this.y - 40)) < Math.abs(brzinay)) && (Math.abs(arr.get(i).x - this.x) < 40)){
    				brzinay *= (-1);
    				brzinay *= 0.4f;
    				return true;
    			}
    			if(((Math.abs(arr.get(i).y - 40) - this.y) < Math.abs(brzinay)) && (Math.abs(arr.get(i).x - this.x) < 40)){
    				brzinay *= (-1);
    				brzinay *= 0.4f;
    				return true;
    			}
    		}
    	}
    	return false;
    };
}
