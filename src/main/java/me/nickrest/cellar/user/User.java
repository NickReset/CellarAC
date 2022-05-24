package me.nickrest.cellar.user;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Getter @Setter
public class User {
    private Player player;
    private String brand;

    public User(Player player) {
        this.player = player;
    }

    public String getName() {
        return player.getName();
    }

    public boolean isOnGround() {
        double expand = 0.3;
        for(double x = -expand; x <= expand; x += expand) {
            for(double z = -expand; z <= expand; z += expand) {
                if(getPlayer().getLocation().clone().add(x, -0.5001, z).getBlock().getType() != Material.AIR) {
                    return true;
                }
            }
        }
        return false;
    }
}
