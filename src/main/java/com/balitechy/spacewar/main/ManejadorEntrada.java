/* Escucha eventos de teclado y delega su manejo a la clase Juego. */
package com.balitechy.spacewar.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManejadorEntrada extends KeyAdapter {
	private Juego juego;

	public ManejadorEntrada(Juego juego) {
		this.juego = juego;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		juego.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		juego.keyReleased(e);
	}
}
