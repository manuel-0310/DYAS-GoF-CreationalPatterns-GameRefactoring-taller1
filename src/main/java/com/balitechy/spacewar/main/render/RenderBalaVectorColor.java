/* Renderiza las balas como óvalos azules usando gráficos vectoriales. */
package com.balitechy.spacewar.main.render;

import com.balitechy.spacewar.main.Bala;

import java.awt.Color;
import java.awt.Graphics;

public class RenderBalaVectorColor implements RenderBala {

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, Bala.WIDTH, Bala.HEIGHT);
    }
}
