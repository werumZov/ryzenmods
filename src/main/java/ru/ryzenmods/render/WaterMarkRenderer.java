package ru.ryzenmods.render;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import ru.ryzenmods.client.util.MCUtil;
import ru.ryzenmods.client.util.player.Player;

public class WaterMarkRenderer implements HudRenderCallback, MCUtil {


    private static final String DISPLAY_TEXT_USER = "Ryzen Mods v1.0.1(1.21.4) by Ryzen aka werumov - USERMODE";
    private static final String DISPLAY_TEXT_ZAKO = "Ryzen Mods v1.0.1(1.21.4) by Ryzen aka werumov - ZAKO_MODE";
    private static final String DISPLAY_TEXT_DEV = "Ryzen Mods v1.0.1(1.21.4) by Ryzen aka werumov - DEVMODE";


    //private static final String CORD_TEXT = "Coordinates: " + mc.player.getBlockPos().toString();
    private static final int COLOR = 0xFFFFFF;

    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tick) {
        MinecraftClient client = MinecraftClient.getInstance();


        if (client.player == null || client.world == null) return;


        TextRenderer textRenderer = client.textRenderer;


        int screenWidth = client.getWindow().getScaledWidth();
        int screenHeight = client.getWindow().getScaledHeight();


        int x = 10;
        int y = 10;

        int cordX = 10;
        int cordY = 60;

        if (Player.playerName.equals("_3AK0_")) {
            context.drawText(textRenderer, Text.literal(DISPLAY_TEXT_ZAKO), x, y, COLOR, true);
        } if (Player.playerName.equals("DobriiCola")) {
            context.drawText(textRenderer, Text.literal(DISPLAY_TEXT_DEV), x, y, COLOR, true);
        } else {
            context.drawText(textRenderer, Text.literal(DISPLAY_TEXT_USER), x, y, COLOR, true);
        }

    }
}
