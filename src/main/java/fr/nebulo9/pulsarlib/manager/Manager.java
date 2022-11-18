package fr.nebulo9.pulsarlib.manager;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Represents the general <code>Manager</code> to extend to manage commands, listeners, etc.
 * @author Nebulo9
 * @version 1.1
 */
public abstract class Manager {
    protected JavaPlugin instance;

    public Manager(JavaPlugin instance) {
        this.instance = instance;
        register();
    }

    /**
     * <p>Registers all the instances that must be added to the plugin.</p>
     * <p>Called in the constructor.</p>
     */
    public abstract void register();
}
