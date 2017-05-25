package android.myapplicationdev.com.demonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int requestCode = 123;
    int notificationID = 888;

    Button btn_notify_one, btn_notify_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_notify_one = (Button) findViewById(R.id.notiOne);
        btn_notify_two = (Button) findViewById(R.id.notiTwo);

        btn_notify_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                Notification.Builder builder = new Notification.Builder(MainActivity.this);

                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher_round);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);
                Uri uri= RingtoneManager.getDefaultUri
                        (RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);


                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, n);
                finish();


            }
        });

    }
}
