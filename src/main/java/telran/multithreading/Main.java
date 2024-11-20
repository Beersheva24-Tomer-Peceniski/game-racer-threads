package telran.multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger firstThreadID = new AtomicInteger();
        CountDownLatch latch = new CountDownLatch(1);
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("What will be the distance?");
            int distance = Integer.parseInt(reader.readLine());
            System.out.println("What will be the number os participants?");
            int participants = Integer.parseInt(reader.readLine());
            
            Race race = new Race(distance);

            for(int i = 1; i <= participants; i++) {
                Racer racer = new Racer(race, i, firstThreadID, latch);
                racer.start();
            }

            latch.await();
            System.out.printf("Thread %d is the winner!", firstThreadID.get());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}