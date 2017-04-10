package com.endava.threads;

/**
 * Created by vcerbu on 4/7/2017.
 */

public class MaxValueThread extends Thread {

    private int lowExtreme;
    private int highExtreme;
    private int[] array;
    private int maxValue;

    public MaxValueThread(int[] array, int lowExtreme, int highExtreme) {
        this.lowExtreme = lowExtreme;
        this.array = array;
        this.highExtreme = highExtreme;
    }

    public int getLowExtreme() {
        return lowExtreme;
    }

    public void setLowExtreme(int lowExtreme) {
        this.lowExtreme = lowExtreme;
    }

    public int getHighExtreme() {
        return highExtreme;
    }

    public void setHighExtreme(int highExtreme) {
        this.highExtreme = highExtreme;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        maxValue = array[lowExtreme];
        for (int i = lowExtreme; i < highExtreme; i++) {
            System.out.println(array[i]);
            if (array[i] > maxValue)
                maxValue = array[i];
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " has max value " + maxValue);
    }

}
