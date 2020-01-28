package com.example.qeuangans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int NOTIFICATION_ID = 1;
    DatabaseHelper db;
    TextView textsaldo;
    Button list, tahi; // Solusi ERROR 13. Issues #14 //

    public int total;

    //Notification
    public static final String CHANNEL_ID = "01";
    public static final String Name = "Keuangans";
    public static final String Desc = "Desc";
    //private  TimerClass timerClass; // tai mer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this); //Issues #19

        //CASTING
        textsaldo = findViewById(R.id.textsaldo);
        list = findViewById(R.id.List);
        tahi = findViewById(R.id.tahihi); // Solusi ERROR 13. Issues #15

        //PEMANGGILAN METHOD
        jmlSaldo();


    }

    private void jmlSaldo() {
        Cursor cursor = db.totalPemasukan();
        Cursor cursor2 = db.totalPengeluaran();

        cursor.moveToFirst();
        int pemasukan = cursor.getInt(0);

        cursor2.moveToFirst();
        int pengeluaran = cursor2.getInt(0);

        total = pemasukan-pengeluaran;

        textsaldo.setText("Rp "+total);
    }


    //METHOD SALDO
    /**
    private void jmlSalto() {
        Cursor cursor = db.saldo();
        while (cursor.moveToNext()) {
            textsaldo.append("Rp " + cursor.getString(0) + ",00");
        }

        String check = textsaldo.getText().toString();
        if (check.contentEquals("Rp 100000,00"))
            Toast.makeText(MainActivity.this, "Saldo Tipis", Toast.LENGTH_LONG).show();
    }**/



    //PINDAH TOMBOL INPUT DATA
    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, InputData.class);
        startActivity(intent);
    }

    public void list(View view) {
        Intent intent = new Intent(MainActivity.this, List.class);
        startActivity(intent);
    }

    public void Notiftest(View view) {
        long[] PolaGetar = {100, 100};
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_notifsatu)
            .setColor(Color.BLUE)
            .setContentTitle("Issues Notif")
            .setAutoCancel(true)
            .setContentText("Berhasil Pak")
            .setVibrate(PolaGetar);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,builder.build());

    }

    public void pindahin(View view) {
        Intent intent = new Intent(MainActivity.this, List2.class);
        startActivity(intent);
    }
}
