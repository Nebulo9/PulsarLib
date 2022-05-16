package fr.nebulo9.pulsarlib.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileUtil {

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
}
