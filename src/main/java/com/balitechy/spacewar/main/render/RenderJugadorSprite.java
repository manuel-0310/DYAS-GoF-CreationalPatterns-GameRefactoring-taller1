/* Renderiza al jugador usando una imagen de sprite. */
package com.balitechy.spacewar.main.render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.balitechy.spacewar.main.Jugador;
import com.balitechy.spacewar.main.CargadorImg;

public class RenderJugadorSprite implements RenderJugador {
	private BufferedImage image;

	public RenderJugadorSprite() {
		CargadorImg loader = new CargadorImg("/sprites.png");
		try {
			loader.loadImage();
			image = loader.getImage(219, 304, Jugador.WIDTH, Jugador.HEIGHT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g, double x, double y) {
		g.drawImage(image, (int) x, (int) y, null);
	}
}
