/* Fábrica de renderizadores vectoriales coloridos (rojo, azul, amarillo, gris). */
package com.balitechy.spacewar.main.render;

public class FabricaVectorColor implements FabricaRender {

    @Override
    public RenderJugador crearRenderJugador() {
        return new RenderJugadorVectorColor();
    }

    @Override
    public RenderBala crearRenderBala() {
        return new RenderBalaVectorColor();
    }

    @Override
    public RenderFondo crearRenderFondo() {
        return new RenderFondoVectorColor();
    }
}
