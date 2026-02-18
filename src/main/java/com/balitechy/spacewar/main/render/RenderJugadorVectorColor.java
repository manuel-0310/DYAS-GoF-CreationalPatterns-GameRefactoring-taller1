/* Renderiza al jugador como un triángulo rojo usando gráficos vectoriales. */
package com.balitechy.spacewar.main.render;


import java.awt.Color;
import java.awt.Graphics;

public class RenderJugadorVectorColor implements RenderJugador {

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.blue);
        int width = 40;   // ancho del triángulo
        int height = 60;  // alto del triángulo

        int[] xPoints = {(int) x, (int) (x + width / 2), (int) (x + width)};
        int[] yPoints = {(int) y, (int) (y - height), (int) y};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
