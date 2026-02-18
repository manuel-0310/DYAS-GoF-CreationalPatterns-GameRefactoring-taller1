/* Renderiza las balas usando una imagen de sprite. */
package com.balitechy.spacewar.main.render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.balitechy.spacewar.main.Bala;
import com.balitechy.spacewar.main.CargadorImg;

public class RenderBalaSprite implements RenderBala {
	private BufferedImage image;

	public RenderBalaSprite() {
		CargadorImg loader = new CargadorImg("/sprites.png");
		try {
			loader.loadImage();
			image = loader.getImage(35, 52, Bala.WIDTH, Bala.HEIGHT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g, double x, double y) {
		g.drawImage(image, (int) x, (int) y, null);
	}
}
