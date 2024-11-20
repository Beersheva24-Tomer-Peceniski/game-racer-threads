package telran.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Racer extends Thread {
    private Race race;
    private int number;
    private AtomicInteger firstThreadID;
    private CountDownLatch latch;

    public Racer(Race race, int number, AtomicInteger firstThreadID, CountDownLatch latch) {
        this.race = race;
        this.number = number;
        this.firstThreadID = firstThreadID;
        this.latch = latch;
    }

    public void run() {
        int distance = race.getDistance();
        Long sleepTime = race.sleepTime();
        int i = 0;
        while (i < distance) {
            try {
                sleep(sleepTime);
                if(Integer.compare(0, firstThreadID.get()) != 0) {
                    break;
                }
                System.out.println(number);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(Integer.compare(0, firstThreadID.get()) == 0) {
            firstThreadID.set(number);
            latch.countDown();
        }
    }
}