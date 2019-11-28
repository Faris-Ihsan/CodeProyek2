package com.example.qeuangans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InputData2 extends AppCompatActivity {

    EditText jenispengeluaran, jmlpengeluaran;
    TextView tglpengeluaran;
    Button inputkeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data2);
    }

    public void pemasukan(View view) {
        Intent intent = new Intent(InputData2.this, InputData.class);
        startActivity(intent);

        jenispengeluaran = findViewById(R.id.jenispengeluaran);
        jmlpengeluaran = findViewById(R.id.jmlpengeluaran);
        tglpengeluaran = findViewById(R.id.tglpengeluaran);
        inputkeluar = findViewById(R.id.inputkeluar);
    }
}
