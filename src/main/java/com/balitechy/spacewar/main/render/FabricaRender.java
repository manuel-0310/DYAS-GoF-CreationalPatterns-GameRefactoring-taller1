/* Interfaz para crear renderizadores de jugador, balas y fondo. */
package com.balitechy.spacewar.main.render;

public interface FabricaRender {

    RenderJugador crearRenderJugador();
    RenderBala crearRenderBala();
    RenderFondo crearRenderFondo();
}
