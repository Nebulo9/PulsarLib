package fr.nebulo9.pulsarlib.command;

import fr.nebulo9.pulsarlib.PulsarLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PLCommand implements CommandExecutor {
    protected static JavaPlugin INSTANCE;

    public PLCommand() {
        INSTANCE = PulsarLib.getPlugin();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(isNameOrAlias(command,label)) {
            if(isSenderRightType(sender)) {
                return PLExecute(sender,command,args);
            }
        }
        return false;
    }

    public abstract boolean checkArg(String[] args, int index, String value);

    /**
     * The method that will be called in <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandExecutor.html#onCommand(org.bukkit.command.CommandSender,org.bukkit.command.Command,java.lang.String,java.lang.String%5B%5D)">onCommand()</a> method.
     * @param sender the <a href="CommandSender">CommandSender</a> that type the command.
     * @param command the <a href="Command">Command</a> typed.
     * @param args the arguments given with the command.
     */
    public abstract boolean PLExecute(CommandSender sender, Command command, String[] args);

    /**
     * Checks if the instance of the sender is correct or not.
     * @param sender the <a href="CommandSender">CommandSender</a> to check.
     * @return <code>true</code> if the instance is correct, <code>false</code> if not.
     */
    public boolean isSenderRightType(CommandSender sender) {
        return true;
    }

    /**
     * Checks if the typed command matches with the exact name of the command or an alias.
     * @param command the <a href="Command">Command</a> to compare with the label that is the typed command.
     * @param label the type command.
     * @return <code>true</code> if the typed command matches with the name or an alias, <code>false</code> if not.
     */
    public boolean isNameOrAlias(Command command, String label) {
        String commandName = command.getName();
        return commandName.contains(label.toLowerCase()) || commandName.equalsIgnoreCase(label);
    }
}
