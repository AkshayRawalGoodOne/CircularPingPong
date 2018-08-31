package com.CircularPingPong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score extends Entity{

	public Score(){
		super(null);
	}
	public void render(Graphics g)
	{
		g.setColor(Color.RED);
		g.setFont(new Font("Bauhaus 93", 1, 50));
		g.drawString("4", (int)Game.dia/2 - 20, (int)Game.dia/2 - 10);
		g.setColor(Color.BLUE);
		g.drawString("7", (int)Game.dia/2 - 20, (int)Game.dia/2 + 40);
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
