package fr.nebulo9.pulsarlib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public abstract class PLConfig {
    protected JavaPlugin instance;
    protected File configFile;

    protected final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public PLConfig() {
        this.instance = PulsarLib.getPlugin();
        this.configFile = new File(instance.getDataFolder().getPath() + File.separator + "config.json");
    }

    public abstract boolean createConfigFile();

    public abstract boolean writeDefaults();
}