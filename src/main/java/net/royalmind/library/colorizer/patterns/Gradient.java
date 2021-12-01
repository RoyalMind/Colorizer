package net.royalmind.library.colorizer.patterns;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;
import net.royalmind.library.colorizer.Colorizer;

public class Gradient implements IPattern
{
    final private Pattern pattern = Pattern.compile("<G:([0-9A-Fa-f]{6})>(.*?)</G:([0-9A-Fa-f]{6})>");

    @Override
    public String getColoredText(String text) {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find())
        {
            String start = matcher.group(1);
            String content = matcher.group(2);
            String end = matcher.group(3);

            text = text.replace(matcher.group(),
                    getColored(content,
                            new Color(Integer.parseInt(start, 16)),
                            new Color(Integer.parseInt(end, 16))));
        }

        return text;
    }

    @Override
    public String getColoredTextLegacy(String text) {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find())
        {
            String start = matcher.group(1);
            String content = matcher.group(2);
            String end = matcher.group(3);

            text = text.replace(matcher.group(),
                    getColoredLegacy(content,
                            new Color(Integer.parseInt(start, 16)),
                            new Color(Integer.parseInt(end, 16))));
        }

        return text;
    }

    /**
     * Colorea un texto con un Gradiente.
     *
     * @param text El texto que queremos colorear
     * @param start El inicio del gradiente
     * @param end El final del gradiente
     */
    private String getColoredLegacy(String text, Color start, Color end)
    {
        StringBuilder specialColors = new StringBuilder();

        for (String color : Colorizer.getSpecialColors())
        {
            if (text.contains(color))
            {
                specialColors.append(color);
                text = text.replace(color, "");
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        ChatColor[] colors = this.createLegacy(start, end, text.length());

        String[] characters = text.split("");
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(colors[i]).append(specialColors).append(characters[i]);
        }

        return stringBuilder.toString();
    }

    /**
     * Colorea un texto con un Gradiente.
     *
     * @param text El texto que queremos colorear
     * @param start El inicio del gradiente
     * @param end El final del gradiente
     */
    private String getColored(String text, Color start, Color end)
    {
        StringBuilder specialColors = new StringBuilder();

        for (String color : Colorizer.getSpecialColors())
        {
            if (text.contains(color))
            {
                specialColors.append(color);
                text = text.replace(color, "");
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        ChatColor[] colors = this.create(start, end, text.length());

        String[] characters = text.split("");
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(colors[i]).append(specialColors).append(characters[i]);
        }

        return stringBuilder.toString();
    }

    private ChatColor[] create(Color start, Color end, int step)
    {
        ChatColor[] colors = new ChatColor[step];

        int RED = Math.abs(start.getRed() - end.getRed()) / (step - 1);
        int GREEN = Math.abs(start.getGreen() - end.getGreen()) / (step - 1);
        int BLUE = Math.abs(start.getBlue() - end.getBlue()) / (step - 1);

        int[] direction = new int[]{
                start.getRed() < end.getRed() ? +1 : -1,
                start.getGreen() < end.getGreen() ? +1 : -1,
                start.getBlue() < end.getBlue() ? +1 : -1
        };

        for (int i = 0; i < step; i++) {
            Color color =
                    new Color(
                            start.getRed() + ((RED * i) * direction[0]),
                            start.getGreen() + ((GREEN * i) * direction[1]),
                            start.getBlue() + ((BLUE * i) * direction[2]));

            colors[i] = ChatColor.of(color);
        }
        return colors;
    }

    private ChatColor[] createLegacy(Color start, Color end, int step)
    {
        ChatColor[] colors = new ChatColor[step];

        int RED = Math.abs(start.getRed() - end.getRed()) / (step - 1);
        int GREEN = Math.abs(start.getGreen() - end.getGreen()) / (step - 1);
        int BLUE = Math.abs(start.getBlue() - end.getBlue()) / (step - 1);

        int[] direction = new int[]{
                start.getRed() < end.getRed() ? +1 : -1,
                start.getGreen() < end.getGreen() ? +1 : -1,
                start.getBlue() < end.getBlue() ? +1 : -1
        };

        for (int i = 0; i < step; i++) {
            Color color =
                    new Color(
                            start.getRed() + ((RED * i) * direction[0]),
                            start.getGreen() + ((GREEN * i) * direction[1]),
                            start.getBlue() + ((BLUE * i) * direction[2]));

            colors[i] = Colorizer.getClosestColor(color);
        }
        return colors;
    }
}