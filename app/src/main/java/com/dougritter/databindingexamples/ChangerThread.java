package com.dougritter.databindingexamples;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

public class ChangerThread {
    private Timer timer;
    private boolean isRunning;

    public ChangerThread() {}

    public boolean threadIsRunning() {
        return isRunning;
    }

    public void startThread() {
        int delay = 100;
        int period = 1500;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                EventBus.getDefault().post(new EventMakeChanges());
            }
        }, delay, period);

        isRunning = true;

    }

    public void stopThread() {
        timer.cancel();
        timer = null;
        isRunning = false;
    }


}
