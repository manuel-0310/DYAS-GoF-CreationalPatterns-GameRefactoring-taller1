/* Renderiza el fondo gris oscuro con círculo amarillo usando gráficos vectoriales. */
package com.balitechy.spacewar.main.render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class RenderFondoVectorColor implements RenderFondo {

    @Override
    public void render(Graphics g, Canvas c) {
        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(Color.YELLOW);
        g.drawOval(10, 10, 200, 200);
    }
}
