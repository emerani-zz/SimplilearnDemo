package com.ezraerani.simplilearndemo;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import org.junit.Test;

import static android.content.ContentValues.TAG;

/**
 * Created by ezraerani on 8/15/17.
 */
public class ServiceActivityTest {

//    @org.mockito.Mock
//    Context context;

    MyService service;
    boolean isBound = false;

    @Test
    public void onCreate() throws Exception {

    }

    @Test
    public void onStart() throws Exception {

    }

    @Test
    public void onClick() throws Exception {

    }

    @Test
    public void onStop() throws Exception {

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected");
            MyService.LocalBinder binder = (MyService.LocalBinder) iBinder;
            service = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

}