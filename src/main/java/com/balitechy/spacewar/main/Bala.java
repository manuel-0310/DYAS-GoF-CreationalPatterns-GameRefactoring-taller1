/* Representa una bala disparada por el jugador que se mueve hacia arriba. */
package com.balitechy.spacewar.main;

public class Bala {
	private double x, y;

	public static final int WIDTH = 11;
	public static final int HEIGHT = 21;

	public Bala(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void tick() {
		y -= 5;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
