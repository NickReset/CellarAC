package me.nickrest.cellar.util;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

@UtilityClass
public class DebugUtil {

    public static void debug(Object message) {
        Bukkit.broadcastMessage("[Debug] " + message);
    }
}
