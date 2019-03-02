package com.ana;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore sem1 = new Semaphore(0);
        Semaphore sem2 = new Semaphore(0);
        Semaphore sem3 = new Semaphore(0);
        Semaphore sem4 = new Semaphore(0);
        Semaphore sem5 = new Semaphore(0);
        Semaphore sem6 = new Semaphore(0);
        Semaphore sem7 = new Semaphore(0);

        //new Runnable()
        //7 is not dependent
        new Thread(() -> Release("7",sem7)).start();

        new Thread(() -> {
            //5 and 6 depend on 7
            try {
                sem7.acquire();
                Release("5",sem5);
                Release("6",sem6);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            //3 and 4 depend on 6
            try {
                sem6.acquire();
                Release("3",sem3);
                Release("4",sem4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            //1 and 2 depend on 5
            try {
                sem5.acquire();
                Release("1",sem1);
                Release("2",sem2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static void Release(String nr, Semaphore semaphoreToRelease){

        try {
            System.out.printf("Thread  %s\n",nr);
            semaphoreToRelease.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
