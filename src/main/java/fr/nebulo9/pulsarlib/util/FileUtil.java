package fr.nebulo9.pulsarlib.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nebulo9.pulsarlib.message.Message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileUtil {

    protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static void download(String url, File result) {
        try {
            ReadableByteChannel channel = Channels.newChannel(new URL(url).openStream());
            FileOutputStream outStream = new FileOutputStream(result);
            FileChannel fileChannel = outStream.getChannel();

            fileChannel.transferFrom(channel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File createFile(String path) {
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

    public static void createFile(File file) {
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

    public static void writeInFile(String path,String content) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeInfFile(File file, Object contentToJSON) {
        try {
            FileWriter fw = new FileWriter(file);
            String contentJSON = "";
            if(contentToJSON != null) {
                contentJSON = GSON.toJson(contentToJSON);
            }
            fw.write(contentJSON);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
