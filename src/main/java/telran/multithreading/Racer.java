package telran.multithreading;

import java.util.Random;

public class Racer extends Thread {
    private Race race;
    private int number;
    private Long executionTime;

    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            race.startSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int minSleep = race.getMinSleep();
        int maxSleep = race.getMaxSleep();
        int distance = race.getDistance();
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < distance; i++) {
            try {
                sleep(random.nextInt(minSleep, maxSleep + 1));
                System.out.printf("%d - step %d\n", number, i);
            } catch (InterruptedException e) {
            }
        }
        long finish = System.currentTimeMillis();
        executionTime = finish - start;
        race.addPosition(this);
    }

    @Override
    public String toString() {
        return "Racer number: " + Integer.toString(number) + " || Running Time: " + Long.toString(executionTime);
    }
}