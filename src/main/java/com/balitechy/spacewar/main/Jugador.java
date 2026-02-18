/* Representa al jugador: posición, movimiento y disparo de balas dentro de los límites de la ventana. */
package com.balitechy.spacewar.main;

public class Jugador {
	private double x, y;
	private double velX, velY;

	public static final int WIDTH = 56;
	public static final int HEIGHT = 28;

	private Juego juego;

	public Jugador(double x, double y, Juego juego) {
		this.x = x;
		this.y = y;
		this.juego = juego;
	}

	public void tick() {
		x += velX;
		y += velY;

		if (x < 0) x = 0;
		if (x > Juego.WIDTH * Juego.SCALE - WIDTH) x = Juego.WIDTH * Juego.SCALE - WIDTH;
		if (y < 0) y = 0;
		if (y > Juego.HEIGHT * Juego.SCALE - HEIGHT) y = Juego.HEIGHT * Juego.SCALE - HEIGHT;
	}

	public void shoot() {
		Bala bala = new Bala(x + (WIDTH / 2) - 5, y - 18);
		juego.getBalas().agregarBala(bala);
	}

	public double getX() { return x; }
	public double getY() { return y; }
	public void setVelX(double velX) { this.velX = velX; }
	public void setVelY(double velY) { this.velY = velY; }
}
