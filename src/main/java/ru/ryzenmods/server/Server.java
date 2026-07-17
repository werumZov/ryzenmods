package ru.ryzenmods.server;


import net.minecraft.client.network.ClientPlayNetworkHandler;
import ru.ryzenmods.client.util.MCUtil;





public class Server implements MCUtil {
    ClientPlayNetworkHandler networkHandler = mc.getNetworkHandler();
    String currentServer = networkHandler.getConnection().getAddress().toString();
    ServerList list;

    public void check(boolean cache) {
        if (cache) {
            if (currentServer.equals(list.hw) || currentServer.equals(list.ft) || currentServer.equals(list.rw)) {

            }
        }
    }
}
