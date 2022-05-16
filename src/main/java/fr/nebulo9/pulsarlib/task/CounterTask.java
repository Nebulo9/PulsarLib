package fr.nebulo9.pulsarlib.task;

import org.bukkit.scheduler.BukkitRunnable;

public class CounterTask extends BukkitRunnable {

    private final Runnable whileCounter;
    private final Runnable onCancel;
    private long counter;

    public CounterTask(long counter, Runnable whileCounter) {
        this.counter = counter;
        this.whileCounter = whileCounter;
        this.onCancel = null;
    }

    public CounterTask(long counter,Runnable whileCounter,Runnable onCancel) {
        this.counter = counter;
        this.whileCounter = whileCounter;
        this.onCancel = onCancel;
    }

    public CounterTask(Runnable onCancel, long counter) {
        this.onCancel = onCancel;
        this.counter = counter;
        this.whileCounter = null;
    }

    @Override
    public void run() {
        if(counter > 0) {
            if(whileCounter != null) {
                whileCounter.run();
            }
            counter--;
        } else {
            if(onCancel != null) {
                onCancel.run();
            }
            this.cancel();
        }
    }
}
