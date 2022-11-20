package fr.nebulo9.pulsarlib.player;

import com.google.gson.annotations.Expose;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PLPlayer plPlayer = (PLPlayer) o;
        return Objects.equals(uuid, plPlayer.uuid) && Objects.equals(name, plPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name);
    }
}
