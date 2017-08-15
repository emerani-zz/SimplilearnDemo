package com.ezraerani.simplilearndemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {

    private final String TAG = getClass().getSimpleName();

    private final IBinder iBinder = new LocalBinder();

    private final Random generator = new Random();

    public MyService() {
    }

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return iBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public int getRandomNumber() {
        return generator.nextInt(100);
    }
}
