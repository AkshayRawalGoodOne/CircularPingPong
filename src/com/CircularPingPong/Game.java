package com.CircularPingPong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -2913450863712047374L;
	public static double dia = 450.0;
	private boolean running = false;
	private Thread thread;
	InputHandler input;
	Handler handler;
	Score score;
	BufferedImage baseImage;
	BufferedImageLoader loader;
	Clock clock;

	public enum ID {

		Player(), Ball(), Opponent(), Player2();
	}

	public Game() {

		handler = new Handler();
		loader = new BufferedImageLoader();
		baseImage = loader.loadImage("/PlayArea.png");
		clock = new Clock();
		ResetGame();
		input = new InputHandler(handler);
		score = new Score();
		addKeyListener(input);
		new Window(dia, this);

	}

	public void run() {

		int fps = 0;
		long timer = 0;
		long previousTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double na = 1000000000.0 / amountOfTicks;
		double delta = 0.0;
		while (running) {
			requestFocus();
			long currentTime = System.nanoTime();
			delta += (currentTime - previousTime) / na;
			previousTime = currentTime;
			if (delta >= 1) {
				tick();
				delta--;
				fps++;
				// previousTime = currentTime;
			}
			if (running)
				render();
			
			if (System.currentTimeMillis() - timer > 1000) {
				System.out.println(fps + " fps");
				fps = 0;
				timer = System.currentTimeMillis();
			}

		}
		stop();
	}

	public synchronized void start() {

		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {

		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void tick() {
		handler.tick();
	}

	public void render() {

		BufferedImage img = new BufferedImage((int) dia, (int) dia, BufferedImage.TYPE_INT_ARGB);
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics og = img.getGraphics();
		g.drawImage(baseImage, 0, 0, this);
		og.setColor(Color.WHITE);
		og.drawLine(0, (int) (dia / 2), (int) (dia), (int) (dia / 2));
		handler.render(og);
		g.drawImage(img, 0, 0, this);
		g.dispose();
		bs.show();
	}

	public static int clamp(double var, double a, double b) {
		if (var > Math.max(a, b))
			return (int) Math.max(a, b);
		else if (var < Math.min(a, b))
			return (int) Math.min(a, b);
		else
			return (int) var;
	}

	public void ResetGame() {

		handler.clearAll();
		handler.addObject(new Player(ID.Player,- 98));
		handler.addObject(new Opponent(ID.Opponent,+ 82));
		handler.addObject(new Clock());
		handler.addObject(new Score());
		handler.addObject(new Ball(ID.Ball, handler, input));
		Opponent.getBallEntity(handler);
	}

	public static double ToRadians(double deg) {
		return (Math.PI / 180 * deg);
	}

	public static double toDegrees(double rad) {
		return (180 / Math.PI * rad);
	}

	public static double roundoffAngle(double angle) {
		if (angle > 360)
			return angle - 360;
		if (angle < 0)
			return angle + 360;
		if (angle == 360 || angle == 0)
			return 0;

		return angle;

	}

	public static double correctAngle(double angle) {
		if (angle > 180)
			return angle - 360;

		return angle;

	}

	public static void main(String[] args) {
		// AudioPlayer.load();
		new Game();

	}
}
