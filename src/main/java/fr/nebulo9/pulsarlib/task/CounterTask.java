package fr.nebulo9.pulsarlib.task;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class CounterTask extends BukkitRunnable {

    private Runnable function;
    private int counter;

    public CounterTask(int counter, Runnable function) {
        this.counter = counter;
        this.function = function;
    }

    @Override
    public void run() {
        if(counter > 0) {
            function.run();
            counter--;
        } else {
            this.cancel();
        }
    }
}