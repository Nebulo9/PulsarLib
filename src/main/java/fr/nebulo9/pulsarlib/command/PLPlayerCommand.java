package fr.nebulo9.pulsarlib.command;

import fr.nebulo9.pulsarlib.message.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PLPlayerCommand extends PLCommand {
    public PLPlayerCommand() {
        super();
    }

    @Override
    public boolean PLExecute(CommandSender sender, Command command, String[] args) {
        Player playerSender = (Player) sender;
        return PLPExecute(playerSender,command,args);
    }

    public abstract boolean PLPExecute(Player sender, Command command, String[] args);

    @Override
    public boolean isSenderRightType(CommandSender sender) {
        if(sender instanceof Player) {
            return true;
        }
        Message.senderErrorMessage(sender,"Only a player can execute this command.");
        return false;
    }
}
