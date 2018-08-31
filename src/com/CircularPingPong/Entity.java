package com.CircularPingPong;

import com.CircularPingPong.Game.ID;
import java.awt.Graphics;

public abstract class Entity
{
	protected double x, y, velX, velY, startAngle, AngularVelocity;
	double suitableAngle, distance;
	protected ID id;
	
	public Entity(ID id){
		this.id = id;
		suitableAngle = 90;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getVelY(){
		return velY;
	}
	public double getVelX(){
		return velX;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setVelX(double velX){
		this.velX = velX;
	}
	public void setVelY(double velY){
		this.velY = velY;
	}
	public void setAV(double av){
		AngularVelocity = av;
	}
	public void setSuitableAngle(double suitableAngle)
	{
		this.suitableAngle = suitableAngle;
	}
	
}