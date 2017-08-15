package com.ezraerani.simplilearndemo;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Created by ezraerani on 8/13/17.
 */

public class Utils {

    public static void threadDemo() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Thread name", Thread.currentThread().getName());
                Looper.prepare();

                for (int i = 0; i < 5; i++) {

                    final int x = i;

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("Runnable " + x, Thread.currentThread().getName());
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Looper.loop();
            }
        });


        t1.start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
