package me.nickrest.cellar.manager;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.cellar.user.User;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class UserManager {

    public Map<User, CheckManager> users = new HashMap<>();

    public void addUser(Player user) {
        User u = new User(user);
        users.put(u, new CheckManager(u));
    }

    public void removeUser(Player user) {
        users.remove(new User(user));
    }

    public User getUserByPlayer(Player user) {
        return users.entrySet().stream().filter(entry -> entry.getKey().getPlayer().equals(user)).findFirst().get().getKey();
    }

    public CheckManager getCheckManagerByPlayer(Player user) {
        return users.entrySet().stream().filter(entry -> entry.getKey().getPlayer().equals(user)).findFirst().get().getValue();
    }

}
