/* Renderiza el fondo como rectángulo negro con círculo blanco usando gráficos vectoriales. */
package com.balitechy.spacewar.main.render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class RenderFondoVector implements RenderFondo {

    @Override
    public void render(Graphics g, Canvas c) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(Color.WHITE);
        g.drawOval(10, 10, 200, 200);
    }
}
