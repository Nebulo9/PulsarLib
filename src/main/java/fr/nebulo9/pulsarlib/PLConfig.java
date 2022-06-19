package fr.nebulo9.pulsarlib;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nebulo9.pulsarlib.message.Message;
import fr.nebulo9.pulsarlib.util.FileUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.HashMap;

public abstract class PLConfig {
    protected JavaPlugin instance;
    protected File configFile;

    protected final HashMap<String,Object> defaultValues;

    protected HashMap<String,Object> values;

    protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public PLConfig() {
        this.instance = PulsarLib.getPlugin();
        this.configFile = new File(instance.getDataFolder().getPath() + File.separator + "config.json");
        instance.getDataFolder().mkdir();
        FileUtil.createFile(configFile);
        defaultValues = setDefaultValues();
        FileUtil.writeInfFile(configFile,defaultValues);
    }

    public HashMap<String,Object> setDefaultValues() {
        return null;
    }

    public void reloadConfig() {
        Message.logInfo("Loading config...");
        values = GSON.fromJson(FileUtil.readFromFile(configFile),new TypeToken<HashMap<String,Object>>(){}.getType());
        Message.logInfo("Config loaded successfully");
    }
}