import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vcerbu on 4/7/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("------------------MaxValue------------------");
        Random rand = new Random();
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(50);
        }
        System.out.println("Array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


        try {
            CalculateMaxFromThreads.getMaxValue(array);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("----------------ReverseHello----------------");
        ReverseHello thread = new ReverseHello(1);
        thread.start();
        thread.sleep(1000);


        System.out.println("----------------LambdaThreads----------------");
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Runnable atomicThread = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            atomicInteger.addAndGet(6);
            System.out.println("Value of atomicInteger: " + atomicInteger);
        };
        new Thread(atomicThread).start();
    }
}
