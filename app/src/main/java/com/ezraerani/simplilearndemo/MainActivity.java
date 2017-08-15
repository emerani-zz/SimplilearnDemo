package com.ezraerani.simplilearndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,
View.OnClickListener{

    private final String TAG = getClass().getSimpleName();

    View gestureView;
    GestureDetector detector;
    MyGestureListener listener;
    int[] colors = new int[] {android.R.color.holo_red_dark, android.R.color.holo_green_dark,
            android.R.color.holo_blue_dark, android.R.color.holo_purple, android.R.color.darker_gray,
            android.R.color.holo_orange_dark, android.R.color.black};

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");
        gestureView = findViewById(R.id.mainActivityGestureView);
        listener = new MyGestureListener();
        detector = new GestureDetector(this, listener);
        gestureView.setOnTouchListener(this);

        changeBackground();

        getSupportActionBar().setTitle("Perform a Gesture");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void changeBackground() {
        gestureView.setBackgroundResource(getRandomColor());
    }

    public int getRandomColor() {
        Log.d(TAG, "getRandomColor");
        return colors[random.nextInt(colors.length)];
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d(TAG, "onTouch");
        detector.onTouchEvent(motionEvent);
        return true;
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
    }

    private class MyGestureListener implements GestureDetector.OnGestureListener {
        private final String TAG = getClass().getSimpleName();

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.d(TAG, "onDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.d(TAG, "onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.d(TAG, "onSingleTapUp");
            changeBackground();
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.d(TAG, "onScroll");
            float delta = motionEvent.getY() - motionEvent1.getY();
            Log.d(TAG, "scroll delta = " + delta);
            if (delta < 0) {
                Log.d(TAG, "scrolling down...");
            } else {
                Log.d(TAG, "scrolling up!");
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.d(TAG, "onLongPress");

        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.d(TAG, "onFling");

            float deltaY = motionEvent.getY() - motionEvent1.getY();
            float deltaX = motionEvent.getX() - motionEvent1.getX();

            if (deltaX < 0) {
                Log.d("onFling", "RIGHT");
            }  else {
                Log.d("onFling", "LEFT");
            }

            if (deltaY > 0) {
                Log.d("onFling", "UP");
            } else {
                Log.d("onFling", "DOWN");
            }

            return false;
        }
    }
}
