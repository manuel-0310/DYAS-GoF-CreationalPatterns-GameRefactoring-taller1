/* Administra la lista de balas, su movimiento y renderizado. */
package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.util.LinkedList;
import com.balitechy.spacewar.main.render.RenderBala;

public class ControladorBalas {
	private LinkedList<Bala> balas = new LinkedList<>();

	public void tick() {
		balas.removeIf(bala -> bala.getY() < 0);
		balas.forEach(Bala::tick);
	}

	public void render(Graphics g, RenderBala renderBala) {
		balas.forEach(bala -> renderBala.render(g, bala.getX(), bala.getY()));
	}

	public void agregarBala(Bala bala) {
		balas.add(bala);
	}
}
