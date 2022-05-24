package me.nickrest.cellar.manager;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.cellar.check.Check;
import me.nickrest.cellar.user.User;

import java.util.ArrayList;

@Getter @Setter
public class CheckManager {

    private ArrayList<Check> checks = new ArrayList<>();

    public CheckManager(User user) {
        checks.forEach(check -> check.setUser(user));
    }

    /**
     * Adds a check to the list of checks
     * @param check The check to add
     */
    private void registerCheck(Check check) {
        checks.add(check);
    }
}
