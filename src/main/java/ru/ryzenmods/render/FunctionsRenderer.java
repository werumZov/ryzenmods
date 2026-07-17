package ru.ryzenmods.render;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import ru.ryzenmods.RyzenMods;
import ru.ryzenmods.client.util.MCUtil;

public class FunctionsRenderer implements HudRenderCallback, MCUtil {
    public static boolean showStatus = RyzenMods.showStatus;
    public static boolean showStatus_HAND = RyzenMods.showStatus_HAND;


    public static final String sprint = "Sprint Toggled";
    public static final String fastexp = "FastExp Toggled";


    @Override
    public void onHudRender(DrawContext context, RenderTickCounter renderTickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();


        if (client.player == null || client.world == null) return;
        TextRenderer textRenderer = client.textRenderer;


        int x = 10;
        int y = 20;
        int color = -1;

        int xE = 10;
        int yE = 30;
        int colorE = -1;


        if (showStatus) {
            context.drawText(textRenderer, sprint, x, y, color, true);
        }
        if (showStatus_HAND) {
            context.drawText(textRenderer, fastexp, xE, yE, colorE, true);
        }

    }
}
