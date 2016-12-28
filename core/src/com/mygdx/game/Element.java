package com.mygdx.game;

import java.util.ArrayList;

public abstract class Element {
	
	public float x; public float y;
	public float brzinax; public float brzinay;
	abstract void pomeri(Podloga p);
   
    
    public boolean proveriKol(ArrayList<Element> arr){
    	for(int i = 0; i < arr.size(); i++){
    		if(arr.get(i) != this){
    			if((Math.abs(arr.get(i).x - (this.x + 42)) < brzinax) && (Math.abs(arr.get(i).y - this.y) < 42)){
    				brzinax *= (-1);
    				brzinax *= 0.4f;
    				return true;
    			}
    			if(((Math.abs(arr.get(i).x - 42) - this.x) < brzinax) && (Math.abs(arr.get(i).y - this.y) < 42)){
    				brzinax *= (-1);
    				brzinax *= 0.4f;
    				return true;
    			}
    			if((Math.abs(arr.get(i).y - (this.y - 42)) < brzinay) && (Math.abs(arr.get(i).x - this.x) < 42)){
    				brzinay *= (-1);
    				brzinay *= 0.4f;
    				return true;
    			}
    			if(((Math.abs(arr.get(i).y - 42) - this.y) < brzinay) && (Math.abs(arr.get(i).x - this.x) < 42)){
    				brzinay *= (-1);
    				brzinay *= 0.4f;
    				return true;
    			}
    		}
    	}
    	return false;
    };
}
