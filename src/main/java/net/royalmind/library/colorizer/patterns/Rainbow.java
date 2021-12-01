package net.royalmind.library.colorizer.patterns;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;
import net.royalmind.library.colorizer.Colorizer;

public class Rainbow implements IPattern
{
    final Pattern pattern = Pattern.compile("<RB([0-9]{1,3})>(.*?)</RB>");

    /**
     * Aplica un patrón de arco iris al texto proporcionado.
     * La salida podría ser la misma que la entrada si este patrón no está presente.
     *
     * @param text El texto al que se debe aplicar este patrón
     * @return El nuevo texto con patrón aplicado
     */
    @Override
    public String getColoredText(String text)
    {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String saturation = matcher.group(1);
            String content = matcher.group(2);
            text = text.replace(matcher.group(), getColored(content, Float.parseFloat(saturation)));
        }

        return text;
    }

    /**
     * Aplica un patrón de arco iris al texto proporcionado.
     * La salida podría ser la misma que la entrada si este patrón no está presente.
     *
     * @param text El texto al que se debe aplicar este patrón
     * @return El nuevo texto con patrón aplicado
     */
    @Override
    public String getColoredTextLegacy(String text)
    {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String saturation = matcher.group(1);
            String content = matcher.group(2);
            text = text.replace(matcher.group(), getColoredLegacy(content, Float.parseFloat(saturation)));
        }

        return text;
    }

    /**
     * Colors a String with rainbow colors.
     *
     * @param text El texto que debería tener los colores del arco iris.
     * @param saturation La saturación de los colores del arco iris.
     */
    private static String getColored(String text, float saturation)
    {
        StringBuilder specialColors = new StringBuilder();
        for (String color : Colorizer.getSpecialColors()) {
            if (text.contains(color)) {
                specialColors.append(color);
                text = text.replace(color, "");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        ChatColor[] colors = Rainbow.create(text.length(), saturation);
        String[] characters = text.split("");
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(colors[i]).append(specialColors).append(characters[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * Colors a String with rainbow colors.
     *
     * @param text El texto que debería tener los colores del arco iris.
     * @param saturation La saturación de los colores del arco iris.
     */
    private static String getColoredLegacy(String text, float saturation)
    {
        StringBuilder specialColors = new StringBuilder();
        for (String color : Colorizer.getSpecialColors()) {
            if (text.contains(color)) {
                specialColors.append(color);
                text = text.replace(color, "");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        ChatColor[] colors = Rainbow.createLegacy(text.length(), saturation);
        String[] characters = text.split("");
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(colors[i]).append(specialColors).append(characters[i]);
        }
        return stringBuilder.toString();
    }

    private static ChatColor[] create(int step, float saturation)
    {
        ChatColor[] colors = new ChatColor[step];
        double colorStep = (1.00 / step);
        for (int i = 0; i < step; i++) {
            Color color = Color.getHSBColor((float) (colorStep * i), saturation, saturation);
            colors[i] = ChatColor.of(color);
        }
        return colors;
    }

    private static ChatColor[] createLegacy(int step, float saturation)
    {
        ChatColor[] colors = new ChatColor[step];
        double colorStep = (1.00 / step);
        for (int i = 0; i < step; i++) {
            Color color = Color.getHSBColor((float) (colorStep * i), saturation, saturation);
            colors[i] = Colorizer.getClosestColor(color);
        }
        return colors;
    }
}