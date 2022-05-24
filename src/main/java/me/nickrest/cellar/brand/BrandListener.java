package me.nickrest.cellar.brand;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import javafx.scene.control.Cell;
import me.nickrest.cellar.Cellar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public class BrandListener implements PluginMessageListener {

    @SuppressWarnings("all")
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte[] message) {
        if(channel.equalsIgnoreCase("minecraft:brand") || channel.equalsIgnoreCase("MC|Brand")) {
            ByteArrayDataInput bytes;
            try {
                bytes = ByteStreams.newDataInput(message);
            } catch (Exception e) {
                if (channel == "minecraft:brand");
                return;
            }

            String brand = bytes.readLine().substring(1);
            Cellar.instance.userManager.getUserByPlayer(player).setBrand(brand);
        }
    }
}
