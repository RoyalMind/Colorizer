import org.junit.jupiter.api.Test;

import net.royalmind.minecraft.library.colorizer.Colorizer;

import static org.junit.jupiter.api.Assertions.fail;

public class TranslateTest
{
    @Test
    public void TranslateSolidTest()
    {
        String result = Colorizer.translate("<S:FF0080>SOPORTE RGB CHIDO");

        if (!result.equals("§x§f§f§0§0§8§0SOPORTE RGB CHIDO")) fail("Resultado de generacion de texto no valido.");
    }

    @Test
    public void TranslateSolidLegacyTest()
    {
        String result = Colorizer.translateLegacy("<S:FF0080>SOPORTE RGB CHIDO");

        if (!result.equals("§5SOPORTE RGB CHIDO")) fail("Resultado de generacion de texto no valido.");
    }

    @Test
    public void TranslateRainbowTest()
    {
        String result = Colorizer.translate("<RB1>ESTE ES UN ARCOIRIS MAMALON</RB>");
//        System.out.println(result);
        if (!result.equals("§x§f§f§0§0§0§0E§x§f§f§3§9§0§0S§x§f§f§7§1§0§0T§x§f§f§a§a§0§0E§x§f§f§e§3§0§0 §x§e§3§f§f§0§0E§x§a§a§f§f§0§0S§x§7§1§f§f§0§0 §x§3§9§f§f§0§0U§x§0§0§f§f§0§0N§x§0§0§f§f§3§9 §x§0§0§f§f§7§1A§x§0§0§f§f§a§aR§x§0§0§f§f§e§3C§x§0§0§e§3§f§fO§x§0§0§a§a§f§fI§x§0§0§7§1§f§fR§x§0§0§3§9§f§fI§x§0§0§0§0§f§fS§x§3§9§0§0§f§f §x§7§1§0§0§f§fM§x§a§a§0§0§f§fA§x§e§3§0§0§f§fM§x§f§f§0§0§e§3A§x§f§f§0§0§a§aL§x§f§f§0§0§7§1O§x§f§f§0§0§3§9N")) fail("Resultado de generacion de texto no valido.");
    }
    @Test
    public void TranslateRainbowLegacyTest()
    {
        String result = Colorizer.translateLegacy("<RB1>ESTE ES UN ARCOIRIS MAMALON</RB>");
//        System.out.println(result);
        if (!result.equals("§4E§cS§6T§6E§6 §6E§6S§a §aU§2N§a §aA§3R§bC§bO§3I§9R§9I§1S§9 §9M§5A§dM§dA§5L§cO§cN")) fail("Resultado de generacion de texto no valido.");
    }

    @Test
    public void TranslateRainbow100Test()
    {
        String result = Colorizer.translate("<RB100>ESTE ES UN ARCOIRIS MAMALON</RB>");

        if (!result.equals("§x§f§f§f§f§a§dE§x§f§d§7§a§a§dS§x§d§d§f§a§a§dT§x§f§f§7§f§a§dE§x§d§d§f§a§a§d §x§f§b§f§e§a§dE§x§f§f§f§e§a§dS§x§f§b§f§e§a§d §x§f§b§f§e§a§dU§x§f§f§f§e§a§dN§x§e§f§b§c§3§7 §x§e§f§d§d§c§2A§x§f§f§f§f§4§dR§x§f§f§9§c§d§8C§x§b§d§f§b§9§cO§x§e§f§6§f§9§cI§x§e§d§e§3§9§cR§x§a§d§7§b§9§cI§x§f§f§e§f§9§cS§x§7§a§e§f§9§c §x§f§a§e§f§9§cM§x§7§e§e§f§9§cA§x§f§a§e§f§9§cM§x§f§e§b§d§d§8A§x§f§f§e§f§4§cL§x§f§e§e§d§c§3O§x§f§e§a§d§3§8N")) fail("Resultado de generacion de texto no valido.");
    }

    @Test
    public void TranslateRainbow100LegacyTest()
    {
        String result = Colorizer.translateLegacy("<RB100>ESTE ES UN ARCOIRIS MAMALON</RB>");

        if (!result.equals("§fE§dS§fT§dE§f §fE§fS§f §fU§fN§6 §fA§eR§dC§7O§cI§eR§7I§eS§a §eM§7A§eM§fA§eL§fO§6N")) fail("Resultado de generacion de texto no valido.");
    }

    @Test
    public void TranslateGradientTest()
    {
        String result = Colorizer.translate("<G:2C08BA>Texto genial con un gradientet</G:028A97>");

        if (!result.equals("§x§2§c§0§8§b§aT§x§2§b§0§c§b§9e§x§2§a§1§0§b§8x§x§2§9§1§4§b§7t§x§2§8§1§8§b§6o§x§2§7§1§c§b§5 §x§2§6§2§0§b§4g§x§2§5§2§4§b§3e§x§2§4§2§8§b§2n§x§2§3§2§c§b§1i§x§2§2§3§0§b§0a§x§2§1§3§4§a§fl§x§2§0§3§8§a§e §x§1§f§3§c§a§dc§x§1§e§4§0§a§co§x§1§d§4§4§a§bn§x§1§c§4§8§a§a §x§1§b§4§c§a§9u§x§1§a§5§0§a§8n§x§1§9§5§4§a§7 §x§1§8§5§8§a§6g§x§1§7§5§c§a§5r§x§1§6§6§0§a§4a§x§1§5§6§4§a§3d§x§1§4§6§8§a§2i§x§1§3§6§c§a§1e§x§1§2§7§0§a§0n§x§1§1§7§4§9§ft§x§1§0§7§8§9§ee§x§0§f§7§c§9§dt")) fail("Resultado de generacion de texto no valido.");
    }

    @Test
    public void TranslateGradientLegacyTest()
    {
        String result = Colorizer.translateLegacy("<G:2C08BA>Texto genial con un gradientet</G:028A97>");

        if (!result.equals("§1T§1e§1x§1t§1o§1 §1g§1e§1n§1i§1a§1l§1 §1c§1o§1n§1 §1u§1n§1 §3g§3r§3a§3d§3i§3e§3n§3t§3e§3t")) fail("Resultado de generacion de texto no valido.");
    }
}
