package week7.homework1.thread;

import week7.homework1.util.NightConst;

public class Night extends Thread {

    private final Object lock = new Object();
    private boolean isActive;

    public Night() {
        isActive = true;
    }

    public void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        for (int i = 0; isActive; i++) {
            synchronized (lock) {
                try {
                    System.out.printf("----------------\nNight %s started\n", (i + 1));
                    lock.notifyAll();
                    lock.wait(NightConst.NIGHT_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public Object getLock() {
        return lock;
    }
}
