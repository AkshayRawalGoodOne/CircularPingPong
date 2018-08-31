package com.CircularPingPong;

import java.awt.Color;
import java.awt.Graphics;

import com.CircularPingPong.Game.ID;

public class Opponent extends Entity {

	private static Handler handler;
	static double ballVelY = 0.0;
	double arcCoverStartAngle, arcCoverExtend;
	private static Entity ball;

	public Opponent(ID id, double startAngle) {
		super(id);
		this.startAngle = startAngle;
		AngularVelocity = 2;
		arcCoverExtend = 24;

	}

	@Override
	public void tick() {

		if(ball.velY < 0 && ball.y < 225)
			{
				AngularVelocity = (suitableAngle - startAngle - 8) * 0.06;
				startAngle += AngularVelocity;
				}

		startAngle = Game.clamp(startAngle, + 1,  + 163);
		arcCoverStartAngle = startAngle - 4;
		arcCoverStartAngle = Game.clamp(arcCoverStartAngle,  + 1, + 155);

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.RED);
		// g.setColor(Color.BLUE);
		g.fillArc((int) Game.dia / 2 - 200, (int) Game.dia / 2 - 200, 400, 400, (int) startAngle, 16);
		g.setColor(Color.BLACK);
		g.fillArc((int) Game.dia / 2 - 184, (int) Game.dia / 2 - 184, 368, 368, (int) arcCoverStartAngle,
				(int) arcCoverExtend);
	}

	public static void getBallEntity(Handler handle) {
		handler = handle;
		for (int i = 0; i < handler.entity.size(); i++) {
			if (handler.entity.get(i).id == ID.Ball) {
				ball = handler.entity.get(i);
			}
		}
	}

}
