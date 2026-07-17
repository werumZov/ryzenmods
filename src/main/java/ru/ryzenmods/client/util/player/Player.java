package ru.ryzenmods.client.util.player;

import ru.ryzenmods.client.util.MCUtil;

import java.util.UUID;




public class Player implements MCUtil {
    public static String playerName = mc.player.getName().getString();
    public static String gameProfileName = mc.player.getGameProfile().getName();

    public static UUID uuid = mc.player.getUuid();
    public static String uuidString = uuid.toString();
}
