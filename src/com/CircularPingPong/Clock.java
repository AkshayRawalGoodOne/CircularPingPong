package com.CircularPingPong;

import java.awt.Color;
import java.awt.Graphics;

public class Clock extends Entity {

	static long time;
	static int hourEffect, minutesEffect, secondsEffect;

	public Clock() {
		super(null);
		time = System.currentTimeMillis();
		timeZoneEffect("IST");
	}

	public static int getCurrentSeconds() {

		int totalSeconds = (int) time / 1000;
		int currentSeconds = totalSeconds % 60;
		return currentSeconds + secondsEffect;

	}

	public int getCurrentMinutes() {

		int minutes = (int) (time / (60 * 1000)) % 60;
		return minutes + minutesEffect;
	}

	public int getCurrentHour() {

		int hour = (int) (time / (60 * 1000 * 60)) % 12;
		return hour + hourEffect;
	}

	public static int getCurrentSecondsAngle() {

		int secondsAngle = getCurrentSeconds() * 6;
		return 90 - secondsAngle;
	}

	public int getCurrentMinutesAngle() {
		int minutesAngle = getCurrentMinutes() * 6;
		return 90 - minutesAngle;
	}

	public int getCurrentHourAngle() {
		int hoursAngle = (getCurrentHour() * 30);
		return 90 - hoursAngle - (getCurrentMinutes() / 2);
	}

	public void render(Graphics g) {
		
		g.setColor(new Color(184, 0, 0));
		g.drawOval((int) Game.dia / 2 - 180, (int) Game.dia / 2 - 180, 360, 360);
		g.setColor(new Color(214, 0, 0));
		g.drawOval((int) Game.dia / 2 - 170, (int) Game.dia / 2 - 170, 340, 340);
		g.setColor(new Color(244, 0, 0));
		g.drawOval((int) Game.dia / 2 - 190, (int) Game.dia / 2 - 190, 380, 380);
		
		g.setColor(new Color(184, 0, 0));
		g.drawOval((int) Game.dia / 2 - 100, (int) Game.dia / 2 - 100, 200, 200);
		g.setColor(new Color(214, 0, 0));
		g.drawOval((int) Game.dia / 2 - 80, (int) Game.dia / 2 - 80, 160, 160);
		g.setColor(new Color(244, 0, 0));
		g.drawOval((int) Game.dia / 2 - 60, (int) Game.dia / 2 - 60, 120, 120);
		
		g.setColor(new Color(249, 105, 0));
		g.fillArc((int) Game.dia / 2 - 170, (int) Game.dia / 2 - 170, 340, 340, (getCurrentHourAngle() - 3), 6);
		g.setColor(new Color(166, 66, 0));
		g.fillArc((int) Game.dia / 2 - 150, (int) Game.dia / 2 - 150, 300, 300, (getCurrentHourAngle() - 3), 6);
		
		g.setColor(Color.CYAN);
		g.fillArc((int) Game.dia / 2 - 180, (int) Game.dia / 2 - 180, 360, 360, (getCurrentMinutesAngle() - 2), 4);
		g.setColor(new Color(0, 101, 145));
		g.fillArc((int) Game.dia / 2 - 160, (int) Game.dia / 2 - 160, 320, 320, (getCurrentMinutesAngle() - 2), 4);
		
		g.setColor(new Color(170, 13, 255));
		g.fillArc((int) Game.dia / 2 - 225, (int) Game.dia / 2 - 225, 450, 450, (getCurrentSecondsAngle()), 1);
		g.setColor(Color.WHITE);
		g.fillArc((int) Game.dia / 2 - 190, (int) Game.dia / 2 - 190, 380, 380, (getCurrentSecondsAngle()), 1);
	//	g.fillArc((int) Game.dia / 2 - 225, (int) Game.dia / 2 - 225, 450, 450, (getCurrentSecondsAngle() + 180), 1);
		
	}

	public void showCurrentTime() {
		System.out.print(getCurrentHour() + ":" + getCurrentMinutes() + ":" + getCurrentSeconds() + "-----");
		System.out.println(getCurrentHourAngle() + ":" + getCurrentMinutesAngle() + ":" + getCurrentSecondsAngle());
	}

	public void tick() {

		time = System.currentTimeMillis();
		timeZoneEffect("IST");
	}

	public void timeZoneEffect(String timeZone) {
		if (timeZone == "IST") {
			hourEffect = 5;
			minutesEffect = 30;
			secondsEffect = 16;
		}

	}
}
