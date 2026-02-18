/* Fábrica de renderizadores basados en sprites (imágenes). */
package com.balitechy.spacewar.main.render;

public class FabricaSprite implements FabricaRender {

    @Override
    public RenderJugador crearRenderJugador() {
        return new RenderJugadorSprite();
    }

    @Override
    public RenderBala crearRenderBala() {
        return new RenderBalaSprite();
    }

    @Override
    public RenderFondo crearRenderFondo() {
        return new RenderFondoSprite();
    }
}
