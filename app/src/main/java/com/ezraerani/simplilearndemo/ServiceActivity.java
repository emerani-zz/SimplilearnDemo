package com.ezraerani.simplilearndemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();

    MyService service;

    Button button;

    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        button = (Button) findViewById(R.id.numberButton);
        button.setText("?");
        button.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, MyService.class), connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View view) {
        if (isBound) {
            int x = service.getRandomNumber();
            button.setText(String.valueOf(x));
        }
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

    @Override
    protected void onStop() {
        super.onStop();

        if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }
}
