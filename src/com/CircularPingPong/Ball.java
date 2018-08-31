package com.CircularPingPong;

import java.awt.Color;
import java.awt.Graphics;

import com.CircularPingPong.Game.ID;

public class Ball extends Entity {

	Handler handler;
	InputHandler input;
	double resVel, dist, dist2, centreAngle, correctedCentreAngle, centreAngle2, correctedCentreAngle2;
	double xImpact, yImpact;
	int c = 1;

	public Ball(ID id, Handler handler, InputHandler input) {
		super(id);
		this.handler = handler;
		this.input = input;
		resVel = -5;
		startAngle = 90;
		suitableAngle = startAngle;
		x = 217;
		y = 217;

	}

	@Override
	public void tick() {

		startAngle = Game.roundoffAngle(Game.correctAngle(startAngle));
		velX = resVel * Math.cos(Game.ToRadians(startAngle));
		velY = -resVel * Math.sin(Game.ToRadians(startAngle));
		x += velX;
		y += velY;
		Opponent.ballVelY = velY;

		xImpact = x;
		yImpact = y;
		if (x > 225)
			xImpact += 16;
		if (y > 225)
			yImpact += 16;

		distance = Math.sqrt(Math.pow(xImpact - Game.dia / 2, 2) + Math.pow(yImpact - Game.dia / 2, 2));
		dist = Math.sqrt(Math.pow(xImpact - (Game.dia / 2 + distance), 2) + Math.pow(yImpact - Game.dia / 2, 2));
		dist2 = Math.sqrt(Math.pow(xImpact - (Game.dia / 2 - distance), 2) + Math.pow(yImpact - Game.dia / 2, 2));
		centreAngle = Math.abs(Math.asin(dist / (2 * distance)));
		centreAngle2 = Math.abs(Math.asin(dist2 / (2 * distance)));
		correctedCentreAngle = 2 * Game.toDegrees(centreAngle);
		correctedCentreAngle2 = 2 * Game.toDegrees(centreAngle2);
		correctedCentreAngle2 = 180 - correctedCentreAngle2;

		if (y > 225) {
			correctedCentreAngle *= -1;
			correctedCentreAngle2 *= -1;
		}

		if (x > 255)
			suitableAngle = correctedCentreAngle;
		else
			suitableAngle = correctedCentreAngle2;

		if (distance >= 225)

		{
			resVel = -5;
				startAngle = Clock.getCurrentSecondsAngle() - 45;
				setX(Game.dia / 2 - 8);
				setY(Game.dia / 2 - 8);
		}
		for (int i = 0; i < handler.entity.size(); i++) {
			Entity entity = handler.entity.get(i);
			if (entity.id == ID.Opponent)
				entity.suitableAngle = suitableAngle;
			if (distance >= 188) {

				if (suitableAngle >= entity.startAngle && suitableAngle <= entity.startAngle + 16) {
					c++;
					if (c == 1)
						startAngle += 180;
						//AudioPlayer.getSound("Player_Hit").play();
					if (entity.id == ID.Player) {
						if (InputHandler.keys[0]) {
							startAngle -= 15;
							resVel -= 0.2;
						}
						if (InputHandler.keys[1])
							startAngle += 15;
						resVel -= 0.2;

					}
					if (entity.id == ID.Opponent) {
						if (entity.AngularVelocity < 0) {
							startAngle += 15;
							resVel -= 0.2;
						}
						if (entity.AngularVelocity > 0) {
							startAngle -= 15;
							resVel -= 0.2;
						}

					}

				}
			}
			if (distance < 188)
				c = 0;
		}

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillOval((int) x, (int) y, 16, 16);

	}

}
