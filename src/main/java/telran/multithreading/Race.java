package telran.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class Race {
    private static long min_sleep_time = 100; // 0.1 seconds
    private static long max_sleep_time = 1_000; // 1 seconds
    private int distance;

    public Race(int distance) {
        this.distance = distance;
    }

    public Long sleepTime() {
        return ThreadLocalRandom.current().nextLong(min_sleep_time, max_sleep_time + 1);
    }

    public int getDistance() {
        return distance;
    }
}