package fr.nebulo9.pulsarlib.command;

import fr.nebulo9.pulsarlib.message.Message;
import fr.nebulo9.pulsarlib.message.color.ColorCode;
import fr.nebulo9.pulsarlib.task.CounterTask;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class PingCommand extends PLPlayerCommand {

    private BukkitTask counterTask;

    public PingCommand(JavaPlugin instance) {
        super(instance);
    }

    @Override
    public boolean checkArg(String[] args, int index, String value) {
        return args[index].equalsIgnoreCase(value);
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
        } else if(args.length == 2) {
            int count = Integer.parseInt(args[1]);
            if(checkArg(args,0,"count") && count != 0) {
                counterTask = new CounterTask(count, () -> {
                    Message.playerMessage(sender,Message.build(
                            "Your ping: ",
                            ColorCode.YELLOW.getChat(),
                            String.valueOf(sender.getPing()),
                            "ms",
                            ColorCode.RESET.getChat(),
                            "."
                    ));
                }).runTaskTimer(instance,0L,20L);
                return true;
            } else if(checkArg(args,0,"stop")) {
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
        return false;
    }
}
