package com.nelipa.test.s_randomizer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.nelipa.test.R;
import com.nelipa.test.a_container.ContainerActivity;

public class Push {
    public static final int NOTIFICATION_ID = 1;

    private Context context;
    private NotificationManager mNotificationManager;

    public Push(Context context) {
        this.context = context;
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    }

    public void sendNotification(int randomValue) {
        String newRandom = String.valueOf(randomValue);
        Intent pushIntent = new Intent(context, ContainerActivity.class);
        pushIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pushIntent.putExtra(Randomizer.BUNDLE_LAST_RANDOM, newRandom);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, pushIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(context.getString(R.string.push_random_generated))
                        .setContentText(newRandom);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
