package net.royalmind.library.colorizer.patterns;

public interface IPattern
{
    /**
     * Aplica este patrón a la cadena proporcionada.
     * La salida podría ser la misma que la entrada si este patrón no está presente.
     *
     * @param text La cadena a la que se debe aplicar el patrón.
     * @return La nueva cuerda con patrón aplicado.
     **/
    String getColoredText(String text);


    /**
     * Aplica este patrón a la cadena proporcionada usando los colores que soportan las versiones Minecraft inferiores a 1.16.
     * La salida podría ser la misma que la entrada si este patrón no está presente.
     *
     * @param text La cadena a la que se debe aplicar el patrón.
     * @return La nueva cuerda con patrón aplicado.
     **/
    String getColoredTextLegacy(String text);
}