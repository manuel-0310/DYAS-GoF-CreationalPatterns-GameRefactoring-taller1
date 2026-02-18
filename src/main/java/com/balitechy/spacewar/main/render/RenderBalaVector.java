/* Renderiza las balas como círculos blancos usando gráficos vectoriales. */
package com.balitechy.spacewar.main.render;

import com.balitechy.spacewar.main.Bala;

import java.awt.Color;
import java.awt.Graphics;

public class RenderBalaVector implements RenderBala {

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, Bala.WIDTH, Bala.HEIGHT);
    }
}
