package fr.nebulo9.pulsarlib;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class of the Nebulo9's plugin library.
 * @author Nebulo9
 * @version 1.1
 */
public final class PulsarLib {

    public static final String VERSION = "1.1";

    public static final String MINECRAFT_VERSION = "1.19.2";

    private static JavaPlugin INSTANCE;

    /**
     * Returns the plugin instance.
     * @return a <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html">plugin</a>.
     */
    public static JavaPlugin getPlugin() {
        return INSTANCE;
    }

    /**
     * Assigns the plugin parameter to the member of the class.
     * @param plugin the <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html">plugin</a> to assign.
     */
    public static void setPlugin(JavaPlugin plugin) {
        INSTANCE = plugin;
    }
}
