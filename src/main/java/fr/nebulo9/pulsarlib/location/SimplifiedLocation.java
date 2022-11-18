package fr.nebulo9.pulsarlib.location;

import com.google.gson.annotations.SerializedName;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World.Environment;

import java.util.Map;

/**
 * <p>Represents a simplified version of the Bukkit <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html">Location</a>.</p>
 * <p>Contains the world name, the coordinates, the pitch and the yaw.</p>
 * @author Nebulo9
 * @version 1.1
 */
public class SimplifiedLocation {
    @SerializedName("world")
    private String worldName;
    private Environment env;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;

    public SimplifiedLocation(String worldName, double x, double y, double z, float pitch, float yaw) {
        this.worldName = worldName;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public SimplifiedLocation(String worldName, double x, double y, double z) {
        this.worldName = worldName;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public SimplifiedLocation(Location location) {
        this.worldName = location.getWorld().getName();
        this.env = location.getWorld().getEnvironment();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.pitch = location.getPitch();
        this.yaw = location.getYaw();
    }

    /**
     * Returns the world name.
     * @return the <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/String.html">String</a> world name.
     */
    public String getWorldName() {
        return worldName;
    }

    /**
     * Returns the x-coordinate.
     * @return the <code>double</code> x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     * @return the <code>double</code> y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the z-coordinate.
     * @return the <code>double</code> z-coordinate.
     */
    public double getZ() {
        return z;
    }

    /**
     * Returns the pitch.
     * @return the <code>float</code> pitch.
     */
    private float getPitch() {
        return pitch;
    }

    /**
     * Returns the yaw.
     * @return the <code>float</code> yaw.
     */
    private float getYaw() {
        return yaw;
    }

    private Environment getEnv() {
        return env;
    }

    /**
     * Returns a <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html">Location</a> from the members of this class.
     * @return the <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html">Location</a> from the members of this class.
     */
    public Location getLocation() {
        return new Location(Bukkit.getWorld(worldName),x,y,z);
    }
}
