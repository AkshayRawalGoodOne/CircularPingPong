package com.CircularPingPong;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<Entity> entity = new LinkedList<Entity>();
	
	public void addObject(Entity object){
		entity.add(object);
	}
	public void removeObject(Entity object){
		entity.remove(object);
	}
	public void tick(){
		
		for(int i = 0; i < entity.size(); i++){
			Entity object = entity.get(i);
			object.tick();
		}
			
	}
	public void render(Graphics g){
		
		for(int i = 0; i < entity.size(); i++){
			Entity object = entity.get(i);
			object.render(g);
		}
			
	}
	public void clearAll(){
			
			for(int i = 0; i < entity.size(); i++){
				entity.remove(0);
			}
				
		}
	}


