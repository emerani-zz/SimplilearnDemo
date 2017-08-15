package com.ezraerani.simplilearndemo;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {

    private static final String INTENT_FILTER_1 = "com.ezraerani.simplilearndemo.action.ONE";
    private static final String INTENT_FILTER_2 = "com.ezraerani.simplilearndemo.action.TWO";

    private static final String EXTRA_PARAM1 = "com.ezraerani.simplilearndemo.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.ezraerani.simplilearndemo.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (INTENT_FILTER_1.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                doThingA(param1, param2);
            } else if (INTENT_FILTER_2.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                doThingB(param1, param2);
            }
        }
    }

    private void doThingA(String param1, String param2) {
        /*
        Code to be run
         */
    }

    private void doThingB(String param1, String param2) {
        /*
        Code to be run
         */
    }
}
