/* Fábrica de renderizadores vectoriales (jugador, balas y fondo en blanco y negro). */
package com.balitechy.spacewar.main.render;

public class FabricaVector implements FabricaRender {

    @Override
    public RenderJugador crearRenderJugador() {
        return new RenderJugadorVector();
    }

    @Override
    public RenderBala crearRenderBala() {
        return new RenderBalaVector();
    }

    @Override
    public RenderFondo crearRenderFondo() {
        return new RenderFondoVector();
    }
}
