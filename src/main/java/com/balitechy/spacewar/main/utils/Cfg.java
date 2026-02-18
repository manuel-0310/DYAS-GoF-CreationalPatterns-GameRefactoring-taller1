/* Configuración: provee la fábrica de renderizadores según el estilo (sprite, vector, colorful-vector). */
package com.balitechy.spacewar.main.utils;

import com.balitechy.spacewar.main.render.FabricaRender;
import com.balitechy.spacewar.main.render.FabricaSprite;
import com.balitechy.spacewar.main.render.FabricaVector;
import com.balitechy.spacewar.main.render.FabricaVectorColor;

public class Cfg {

    public static FabricaRender getFabricaRender(String estilo) {
        switch (estilo) {
            case "sprite":
                return new FabricaSprite();
            case "vector":
                return new FabricaVector();
            case "colorful-vector":
                return new FabricaVectorColor();
            default:
                throw new IllegalArgumentException("Estilo no válido: " + estilo);
        }
    }
}
