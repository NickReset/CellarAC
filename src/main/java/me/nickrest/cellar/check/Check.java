package me.nickrest.cellar.check;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketListener;
import javafx.scene.control.Cell;
import lombok.Getter;
import lombok.Setter;
import me.nickrest.cellar.Cellar;
import me.nickrest.cellar.check.info.CheckInfo;
import me.nickrest.cellar.user.User;
import me.nickrest.cellar.util.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

@Getter @Setter
public abstract class Check {

    /* info */
    private CheckInfo info = this.getClass().getAnnotation(CheckInfo.class);

    /* Check Stuff */
    private String name, type;
    private User user;

    public Check() {
        if(this.info == null) {
            throw new RuntimeException("Check class must have CheckInfo annotation!");
        }
        this.name = this.info.name();
        this.type = this.info.type();

        Cellar.instance.protocolManager.addPacketListener(new PacketAdapter(Cellar.instance, getPacketTypes()) {

            public void onPacketReceiving(PacketEvent event) {
                if(user.getPlayer() == event.getPlayer()) handle(event.getPacketType(), event);
            }

        });
    }

    /* Where the check runs */
    public abstract void handle(PacketType packet, PacketEvent event);

    /* Packet Types */
    public abstract PacketType[] getPacketTypes();

    protected void flag() {
        MessageUtil.broadcast("&c" + user.getPlayer().getName() + " &7has failed " + name + "&7(&c" + type + "&7)", true);
    }
}
