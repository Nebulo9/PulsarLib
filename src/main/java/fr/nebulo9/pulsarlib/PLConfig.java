package fr.nebulo9.pulsarlib;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nebulo9.pulsarlib.message.Message;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.HashMap;

public abstract class PLConfig {
    protected JavaPlugin instance;
    protected File configFile;

    protected final HashMap<String,Object> defaultValues;

    protected HashMap<String,Object> values;

    protected final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public PLConfig() {
        this.instance = PulsarLib.getPlugin();
        this.configFile = new File(instance.getDataFolder().getPath() + File.separator + "config.json");
        instance.getDataFolder().mkdir();
        createFile(configFile);
        defaultValues = setDefaultValues();
        writeInfFile(configFile,defaultValues);
    }

    public void createConfigFile() {
        instance.getDataFolder().mkdir();
        try {
            if(!configFile.exists()){
                Message.logInfo("Config file does not exist. Creating it...");
                configFile.createNewFile();
                Message.logInfo("Config file created successfully!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeDefaultValues() {
        try {
            FileWriter fw = new FileWriter(configFile);
            String defaultValuesJSON = "";
            if(defaultValues != null) {
                defaultValuesJSON = gson.toJson(defaultValues);
            }
            fw.write(defaultValuesJSON);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String,Object> setDefaultValues() {
        return null;
    }

    public File createFile(String path) {
        try {
           File newFile = new File(path);
           if(!newFile.exists()) {
               Message.logInfo(Message.build("Creating file: ",newFile.getName()));
               newFile.createNewFile();
               Message.logInfo(Message.build(newFile.getName()," created successfully!"));
           }
           return newFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFile(File file) {
        try {
            if(!file.exists()) {
                Message.logInfo(Message.build("Creating file: ",file.getName()));
                file.createNewFile();
                Message.logInfo(Message.build(file.getName()," created successfully!"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeInFile(String path,String content) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeInfFile(File file, Object content) {
        try {
            FileWriter fw = new FileWriter(file);
            String contentJSON = "";
            if(content != null) {
                contentJSON = gson.toJson(content);
            }
            fw.write(contentJSON);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reloadConfig() {
        try {
            Message.logInfo("Loading config...");
            FileReader fr = new FileReader(configFile);
            values = gson.fromJson(fr,new TypeToken<HashMap<String,Object>>(){}.getType());
            Message.logInfo("Config read successfully");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}