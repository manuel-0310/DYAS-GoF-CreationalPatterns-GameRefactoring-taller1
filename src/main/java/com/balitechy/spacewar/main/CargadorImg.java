/* Carga imágenes desde recursos y permite extraer subimágenes mediante coordenadas y dimensiones. */
package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CargadorImg {
	private String path;
	private BufferedImage image;

	public CargadorImg(String path) {
		this.path = path;
	}

	public BufferedImage loadImage() throws IOException {
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}

	public BufferedImage getImage(int top, int left, int width, int height) {
		return image.getSubimage(top, left, width, height);
	}
}
