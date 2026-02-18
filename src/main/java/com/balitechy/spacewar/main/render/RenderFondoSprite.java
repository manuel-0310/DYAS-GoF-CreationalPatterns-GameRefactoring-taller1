/* Renderiza el fondo usando una imagen de sprite. */
package com.balitechy.spacewar.main.render;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.balitechy.spacewar.main.CargadorImg;

public class RenderFondoSprite implements RenderFondo {
	private BufferedImage image;

	public RenderFondoSprite() {
		CargadorImg loader = new CargadorImg("/bg.png");
		try {
			loader.loadImage();
			image = loader.getImage(0, 0, 640, 480);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g, Canvas c) {
		g.drawImage(image, 0, 0, c.getWidth(), c.getHeight(), c);
	}
}
