package com.example.qeuangans;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class laporan extends AppCompatActivity {

    DatabaseHelper db;
    ListView listLaporanK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        listLaporanK = findViewById(R.id.listLaporanK);

        LK = new ArrayList<>();

        db = new DatabaseHelper(this);

        datalaporankeluar();
    }

    private void datalaporankeluar() {
        Cursor cursor = db.datalaporankeluar();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "TIDAK ADA DATA", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                LK.add("\n" + cursor.getString(0) + "\n" + "Tanggal : " + cursor.getString(5) + "\n" + "\n" + "Pemasukan : " + cursor.getString(1)
                        + "\n" + "Jumlah : Rp " + cursor.getString(2) + ",00" + "\n" + "\n" + "Pengeluaran : " + cursor.getString(3)
                        + "\n" + "Jumlah : Rp" + cursor.getString(4) + ",00" + "\n");
            }
        }
    }
}
