package com.endava.threads;

import java.util.concurrent.*;

/**
 * Created by vcerbu on 4/7/2017.
 */
public class CalculateMaxFromThreads extends Thread {

    public static int getMaxValue(int[] array) throws InterruptedException {

        MaxValueThread threads[] = new MaxValueThread[4];

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        if ((array.length >= 4) && (array.length % 4 == 0)) {

            for (int i = 0; i < 4; i++) {
                MaxValueThread maxValueThread = new MaxValueThread(array, (i * array.length) / 4, ((i + 1) * array.length / 4));
                executorService.submit(maxValueThread);
                Thread.sleep(1000);
                threads[i] = maxValueThread;
            }

            int maxValueGeneral = threads[0].getMaxValue();

            for (int i = 0; i < 4; i++) {
                if (threads[i].getMaxValue() > maxValueGeneral) {
                    maxValueGeneral = threads[i].getMaxValue();
                }
            }
            executorService.shutdown();
            System.out.println("Finished. Max value is: " + maxValueGeneral);
            return maxValueGeneral;
        } else
            System.out.println("Number of array elements must be greater than 4 and divisible to 4");
        return 0;
    }
}
