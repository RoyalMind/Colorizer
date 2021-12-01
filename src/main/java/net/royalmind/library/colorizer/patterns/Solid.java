package net.royalmind.library.colorizer.patterns;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;
import net.royalmind.library.colorizer.Colorizer;

public class Solid implements IPattern
{
    final Pattern pattern = Pattern.compile("<S:([0-9A-Fa-f]{6})>");

    @Override
    public String getColoredText(String text)
    {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String color = matcher.group(1);
            text = text.replace(matcher.group(), getColored(color) + "");
        }

        return text;
    }

    @Override
    public String getColoredTextLegacy(String text)
    {
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String color = matcher.group(1);
            text = text.replace(matcher.group(), getColoredLegacy(color) + "");
        }

        return text;
    }

    public ChatColor getColored(String text) { return ChatColor.of(new Color(Integer.parseInt(text, 16))); }

    public ChatColor getColoredLegacy(String text) { return Colorizer.getClosestColor(new Color(Integer.parseInt(text, 16))); }
}
