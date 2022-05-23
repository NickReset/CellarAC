package me.nickrest.cellar.check;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.cellar.check.info.CheckInfo;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

@Getter @Setter
public abstract class Check {

    /* info */
    private CheckInfo info = this.getClass().getAnnotation(CheckInfo.class);

    /* Check Stuff */
    private String name, type;

    public Check() {
        if(this.info == null) {
            throw new RuntimeException("Check class must have CheckInfo annotation!");
        }
        this.name = this.info.name();
        this.type = this.info.type();
    }

    public abstract void handle(Event event);
}
