package fr.nebulo9.pulsarlib.player;

import com.google.gson.annotations.Expose;
import org.bukkit.Bukkit;

import java.util.UUID;

public abstract class PLPlayer {
    protected final UUID uuid;

    @Expose(serialize = false)
    protected final String name;

    public PLPlayer(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
