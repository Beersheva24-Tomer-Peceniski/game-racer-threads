
package telran.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race {
    private int distance;
    private int minSleep;
    private int maxSleep;
    CountDownLatch startSignal = new CountDownLatch(1);
    private List<Racer> positions = new ArrayList<>();

    public Race(int distance, int minSleep, int maxSleep) {
        this.distance = distance;
        this.minSleep = minSleep;
        this.maxSleep = maxSleep;
    }

    public int getDistance() {
        return distance;
    }

    public int getMinSleep() {
        return minSleep;
    }

    public int getMaxSleep() {
        return maxSleep;
    }

    public void startRace() {
        startSignal.countDown();
    }

    synchronized public void addPosition(Racer racer) {
        positions.add(racer);
    }

    public List<Racer> getPositions() {
        return positions;
    }

}