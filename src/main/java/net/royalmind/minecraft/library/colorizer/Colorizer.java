package net.royalmind.minecraft.library.colorizer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;
import net.md_5.bungee.api.ChatColor;
import net.royalmind.minecraft.library.colorizer.patterns.*;

public class Colorizer
{
    private static final Map<Color, ChatColor> COLORS = ImmutableMap.<Color, ChatColor>builder()
            .put(new Color(0), ChatColor.getByChar('0'))
            .put(new Color(170), ChatColor.getByChar('1'))
            .put(new Color(43520), ChatColor.getByChar('2'))
            .put(new Color(43690), ChatColor.getByChar('3'))
            .put(new Color(11141120), ChatColor.getByChar('4'))
            .put(new Color(11141290), ChatColor.getByChar('5'))
            .put(new Color(16755200), ChatColor.getByChar('6'))
            .put(new Color(11184810), ChatColor.getByChar('7'))
            .put(new Color(5592405), ChatColor.getByChar('8'))
            .put(new Color(5592575), ChatColor.getByChar('9'))
            .put(new Color(5635925), ChatColor.getByChar('a'))
            .put(new Color(5636095), ChatColor.getByChar('b'))
            .put(new Color(16733525), ChatColor.getByChar('c'))
            .put(new Color(16733695), ChatColor.getByChar('d'))
            .put(new Color(16777045), ChatColor.getByChar('e'))
            .put(new Color(16777215), ChatColor.getByChar('f')).build();

    public Map<Color, ChatColor> getColors() { return COLORS; }

    private static final java.util.List<String> SPECIAL_COLORS = Arrays.asList("&l", "&n", "&o", "&k", "&m");

    public static final java.util.List<String> getSpecialColors() { return SPECIAL_COLORS; }

    private static final java.util.List<IPattern> PATTERNS = Arrays.asList(new Gradient(), new Solid(), new Rainbow());

    /**
     * Devuelve el color legacy más cercano al color rgb
     *
     * @param color El color que queremos transformar
     */
    public static ChatColor getClosestColor(Color color) {
        Color nearestColor = null;
        double nearestDistance = Integer.MAX_VALUE;

        for (Color constantColor : COLORS.keySet()) {
            double distance = Math.pow(
                    color.getRed() - constantColor.getRed(), 2) +
                    Math.pow(color.getGreen() - constantColor.getGreen(), 2) +
                    Math.pow(color.getBlue() - constantColor.getBlue(), 2);

            if (nearestDistance > distance) {
                nearestColor = constantColor;
                nearestDistance = distance;
            }
        }
        return COLORS.get(nearestColor);
    }

    /**
     * Procesa una cadena para agregarle color.
     *
     * @param text El texto que queremos procesar.
     * @return El texto procesado con los patrones encontrados.
     */
    public static String translate(String text)
    {
        for (IPattern pattern : PATTERNS) { text = pattern.getColoredText(text); }

        return ChatColor.translateAlternateColorCodes('&', text);
    }

    /**
     * Procesa varios textos en una lista.
     *
     * @param textList La lista textos que estamos procesando.
     * @return La lista de texto procesado
     */
    public static java.util.List<String> translate(java.util.List<String> textList) { return textList.stream()
            .map(Colorizer::translate)
            .collect(Collectors.toList()); }

    /**
     * Remueve colores de un texto.
     *
     * @param text El texto a limpiar.
     * @return El texto limpio.
     * */
    public static String strip(final String text) { return ChatColor.stripColor(Colorizer.translate(text)); }

    /**
     * Procesa una cadena para agregarle color.
     *
     * @param text El texto que queremos procesar.
     * @return El texto procesado con los patrones encontrados.
     */
    public static String translateLegacy(String text)
    {
        for (IPattern pattern : PATTERNS) { text = pattern.getColoredTextLegacy(text); }

        return ChatColor.translateAlternateColorCodes('&', text);
    }

    /**
     * Procesa varios textos en una lista.
     *
     * @param textList La lista textos que estamos procesando.
     * @return La lista de texto procesado
     */
    public static java.util.List<String> translateLegacy(java.util.List<String> textList) { return textList.stream()
            .map(Colorizer::translateLegacy)
            .collect(Collectors.toList()); }

    /**
     * Remueve colores de un texto legacy.
     *
     * @param text El texto a limpiar.
     * @return El texto limpio.
     * */
    @Deprecated
    public static String stripLegacy(final String text) { return ChatColor.stripColor(Colorizer.translateLegacy(text)); }
}
