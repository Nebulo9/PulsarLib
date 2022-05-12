package fr.nebulo9.pulsarlib;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class of the Nebulo9's plugin library.
 * @author Nebulo9
 * @version 1.0
 */
public final class PulsarLib {

    public static final String version = "1.0";

    private static JavaPlugin PLUGIN;

    /**
     * Returns the plugin instance.
     * @return a <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html">plugin</a>.
     */
    public static JavaPlugin getPlugin() {
        return PLUGIN;
    }

    /**
     * Assigns the plugin parameter to the member of the class.
     * @param plugin the <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html">plugin</a> to assign.
     */
    public static void setPlugin(JavaPlugin plugin) {
        PLUGIN = plugin;
    }
}
