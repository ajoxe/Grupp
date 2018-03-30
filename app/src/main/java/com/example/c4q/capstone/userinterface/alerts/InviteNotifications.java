package com.example.c4q.capstone.userinterface.alerts;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.c4q.capstone.R;
import com.example.c4q.capstone.userinterface.events.EventActivity;
import com.example.c4q.capstone.userinterface.user.UserProfileActivity;

/**
 * Created by amirahoxendine on 3/30/18.
 */

public class InviteNotifications {
    private static final int NOTIFICATION_ID = 555;
    private Context context;
    private PendingIntent pendingIntent;
    private NotificationManager notificationManager;
    public InviteNotifications(String title, String description, Context context, String eventId) {
        this.context = context;
        initClass(eventId);
        initNot(title, description);
    }

    public void initClass(String eventId) {
        Intent intent = new Intent(context, EventActivity.class);
        intent.putExtra("eventID", eventId);
        intent.putExtra("eventType", "notnew");
        int requestID = (int) System.currentTimeMillis();
        int flags = PendingIntent.FLAG_CANCEL_CURRENT;
        pendingIntent = PendingIntent.getActivity(context, requestID, intent, flags);
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void initNot(String title, String description) {
        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_grupp_icon_24)
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

}
