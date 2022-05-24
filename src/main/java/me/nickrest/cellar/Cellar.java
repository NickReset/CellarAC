package me.nickrest.cellar;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.nickrest.cellar.brand.BrandListener;
import me.nickrest.cellar.manager.UserManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class Cellar extends JavaPlugin implements Listener {

    /* instance */
    public static Cellar instance;

    /* managers */
    public ProtocolManager protocolManager;
    public UserManager userManager;

    public void onEnable() {
        instance = this;
        protocolManager = ProtocolLibrary.getProtocolManager(); // Checks will add packet listeners based off Check Packets
        userManager = new UserManager(); // All Users will be registered in this

        /*
        * MC|Brand 1.8-
        * minecraft:brand 1.9+
        */
        registerPluginChannel("minecraft:brand", new BrandListener());
        registerPluginChannel("MC|Brand", new BrandListener());

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        userManager.addUser(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        userManager.removeUser(event.getPlayer());
    }

    private void registerPluginChannel(String channel, PluginMessageListener listener) {
        getServer().getMessenger().registerIncomingPluginChannel(this, channel, listener);
    }
}
