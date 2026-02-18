/* Clase principal del juego Space War 2D: inicialización, bucle principal, renderizado y selección de fábrica. */
package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.balitechy.spacewar.main.render.*;

public class Juego extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Space War 2D";

	private boolean running = false;
	private Thread thread;

	private Jugador jugador;
	private ControladorBalas balas;
	private FabricaRender fabricaRender;
	private RenderJugador renderJugador;
	private RenderBala renderBala;
	private RenderFondo renderFondo;

	public void init() {
		requestFocus();
		addKeyListener(new ManejadorEntrada(this));

		renderJugador = fabricaRender.crearRenderJugador();
		renderBala = fabricaRender.crearRenderBala();
		renderFondo = fabricaRender.crearRenderFondo();

		jugador = new Jugador((WIDTH * SCALE - Jugador.WIDTH) / 2, HEIGHT * SCALE - 50, this);
		balas = new ControladorBalas();
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_RIGHT: jugador.setVelX(5); break;
			case KeyEvent.VK_LEFT: jugador.setVelX(-5); break;
			case KeyEvent.VK_UP: jugador.setVelY(-5); break;
			case KeyEvent.VK_DOWN: jugador.setVelY(5); break;
			case KeyEvent.VK_SPACE: jugador.shoot(); break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_RIGHT: jugador.setVelX(0); break;
			case KeyEvent.VK_LEFT: jugador.setVelX(0); break;
			case KeyEvent.VK_UP: jugador.setVelY(0); break;
			case KeyEvent.VK_DOWN: jugador.setVelY(0); break;
		}
	}

	public void tick() {
		jugador.tick();
		balas.tick();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		renderFondo.render(g, this);
		renderJugador.render(g, jugador.getX(), jugador.getY());
		balas.render(g, renderBala);
		g.dispose();
		bs.show();
	}

	public ControladorBalas getBalas() {
		return balas;
	}

	public static void main(String[] args) {
		Juego juego = new Juego();

		juego.mostrarMenu();

		juego.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		JFrame frame = new JFrame(juego.TITLE);
		frame.add(juego);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		juego.iniciar();
	}

	private void mostrarMenu() {
		String[] opciones = {
			"Fábrica Vector",
			"Fábrica Sprite",
			"Fábrica Vector Colorido"
		};

		int choice = JOptionPane.showOptionDialog(
			null,
			"<html><div style='text-align: center; padding: 10px;'>" +
			"<b style='font-size: 14px;'>¡Bienvenido a Space War 2D!</b><br><br>" +
			"Selecciona el tipo de renderizado para el juego:<br><br>" +
			"• <b>Vector</b>: gráficos dibujados con formas geométricas<br>" +
			"• <b>Sprite</b>: gráficos basados en imágenes<br>" +
			"• <b>Vector Colorido</b>: gráficos vectoriales con colores<br>" +
			"</div></html>",
			"Space War 2D - Selección de Modo",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			opciones,
			opciones[0]
		);

		switch (choice) {
			case 0:
				fabricaRender = new FabricaVector();
				break;
			case 1:
				fabricaRender = new FabricaSprite();
				break;
			case 2:
				fabricaRender = new FabricaVectorColor();
				break;
			default:
				fabricaRender = new FabricaVector();
				break;
		}
	}

	private synchronized void iniciar() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double ns = 1000000000 / 60.0;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
	}
}
