package com.ezraerani.simplilearndemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        switch(action) {
            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                notifyUser(context, "disconnected");
                break;
            case "android.intent.action.ACTION_POWER_CONNECTED":
                notifyUser(context, "connected");
                break;
            default:
                break;

        }

    }

    private void notifyUser(Context context, String message) {

//        Toast.makeText(context, "Device is now " + message, Toast.LENGTH_LONG).show();

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent intent = new Intent(context, MovieActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager manager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        android.support.v4.app.NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle("device is now " + message + ".")
                .setOngoing(true)
                .setVibrate(new long[]{0, 500, 500, 500, 500, 500, 500})
                .setSound(soundUri)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setAutoCancel(true);

        manager.notify(1001, builder.build());

    }
}
