package fr.nebulo9.pulsarlib.message;

import fr.nebulo9.pulsarlib.PulsarLib;
import fr.nebulo9.pulsarlib.message.color.ColorCode;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * <p>Provides method to send message to different recipient.</p>
 * @version 1.1
 * @author Nebulo9
 */
public class Message {

    /**
     * <p>Builds a string using StringBuilder to improve performances.</p>
     * @param strings all the string to append.
     * @return the String to build.
     */
    public static String build(String ... strings) {
        StringBuilder sb = new StringBuilder();
        for(String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * <p>Sends the <code>message</code> as info log message.</p>
     * @param message the String message to send.
     */
    public static void logInfo(String message) {
        PulsarLib.getPlugin().getLogger().info(message);
    }

    /**
     * <p>Sends the <code>message</code> as warning log message.</p>
     * @param message the String message to send.
     */
    public static void logWarning(String message) {
        PulsarLib.getPlugin().getLogger().warning(message);
    }

    /**
     * <p>Sends the <code>message</code> as severe log message.</p>
     * @param message the String message to send.
     */
    public static void logSevere(String message) {
        PulsarLib.getPlugin().getLogger().severe(message);
    }

    public static void senderMessage(CommandSender sender, String message) {
        sender.sendMessage(message);
    }

    public static void senderErrorMessage(CommandSender sender, String message) {
        sender.sendMessage(build(ColorCode.RED.getChat(),message));
    }

    /**
     * <p>Sends the <code>message</code> to the console (not as log message).</p>
     * @param message the String message to send.
     */
    public static void consoleMessage(ConsoleCommandSender console, String message) {
        console.sendMessage(message);
    }

    /**
     * <p>Sends the <code>message</code> to the console colored in RED (not as log message).</p>
     * @param message the String message to send.
     * @see ColorCode
     */
    public static void consoleErrorMessage(ConsoleCommandSender console, String message) {
        console.sendMessage(message);
    }

    /**
     * <p>Sends the <code>message</code> to the <code>player</code></p>
     * @param player the <a href="Player">Player</a> that must receive the message.
     * @param message the String message to send.
     */
    public static void playerMessage(Player player, String message) {
        player.sendMessage(message);
    }

    /**
     * <p>Sends the <code>message</code> to the <code>player colored in RED</code></p>
     * @param player the <a href="Player">Player</a> that must receive the message.
     * @param message the String message to send.
     * @see ColorCode
     */
    public static void playerErrorMessage(Player player,String message) {
        player.sendMessage(build(ColorCode.RED.getChat(),message));
    }
}
