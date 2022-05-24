package me.nickrest.cellar.util;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

@UtilityClass
public class MessageUtil {

    public static void broadcast(String message, boolean alert) {
        String m = (ChatColor.translateAlternateColorCodes('&', "&6[&cCellar&6] " + message));
        if(alert) {
            Bukkit.broadcast(m, "cellar.alert");
            return;
        }
        Bukkit.broadcastMessage(m);
    }
}
