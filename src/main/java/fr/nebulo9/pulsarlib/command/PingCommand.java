package fr.nebulo9.pulsarlib.command;

import fr.nebulo9.pulsarlib.message.Message;
import fr.nebulo9.pulsarlib.message.color.ColorCode;
import fr.nebulo9.pulsarlib.task.CounterTask;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class PingCommand extends PLPlayerCommand {

    private BukkitTask counterTask;

    public PingCommand() {
        super();
    }

    @Override
    public boolean PLPExecute(Player sender, Command command, String[] args) {
        if(args.length == 0) {
            Message.playerMessage(sender,Message.build(
                    "Your ping: ",
                    ColorCode.YELLOW.getChat(),
                    String.valueOf(sender.getPing()),
                    "ms",
                    ColorCode.RESET.getChat(),
                    "."
            ));
            return true;
        } else {
            int count;
            try {
                count = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                count = 0;
            }
            if(args[0].equalsIgnoreCase("count") && count != 0) {
                counterTask = new CounterTask(count, () -> {
                    Message.playerMessage(sender,Message.build(
                            "Your ping: ",
                            ColorCode.YELLOW.getChat(),
                            String.valueOf(sender.getPing()),
                            "ms",
                            ColorCode.RESET.getChat(),
                            "."
                    ));
                }).runTaskTimer(INSTANCE,0L,20L);
                return true;
            } else if(args[0].equalsIgnoreCase("stop")) {
                if(counterTask.isCancelled() || counterTask == null) {
                    Message.playerErrorMessage(sender,"There is no ping session to stop.");
                    return false;
                }
                counterTask.cancel();
                Message.playerMessage(sender,"The ping session has been canceled.");
                return true;
            }
            return false;
        }
    }
}
