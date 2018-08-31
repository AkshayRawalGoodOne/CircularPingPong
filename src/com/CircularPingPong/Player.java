package com.CircularPingPong;

import java.awt.Color;
import java.awt.Graphics;

import com.CircularPingPong.Game.ID;

public class Player extends Entity {

	double arcCoverStartAngle, arcCoverExtend;

	public Player(ID id, double startAngle) {
		super(id);
		this.startAngle = startAngle;
		arcCoverStartAngle = startAngle - 4;
		arcCoverExtend = 24;
	}

	@Override
	public void tick() {

		startAngle += AngularVelocity;
		startAngle = Game.clamp(startAngle,- 17,- 179);
		arcCoverStartAngle = startAngle - 4;
		arcCoverStartAngle = Game.clamp(arcCoverStartAngle,  - 179, - 25);

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillArc((int) Game.dia / 2 - 200, (int) Game.dia / 2 - 200, 400, 400, (int) startAngle, 16);
		g.setColor(Color.BLACK);
		g.fillArc((int) Game.dia / 2 - 184, (int) Game.dia / 2 - 184, 368, 368, (int) arcCoverStartAngle,
				(int) arcCoverExtend);
	}

}
