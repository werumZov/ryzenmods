package ru.ryzenmods.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import ru.ryzenmods.client.util.MCUtil;




public class RyzenModsClient implements ClientModInitializer, MCUtil {
    ClientPlayNetworkHandler networkHandler = mc.getNetworkHandler();

    @Override
    public void onInitializeClient() {

    }
}
