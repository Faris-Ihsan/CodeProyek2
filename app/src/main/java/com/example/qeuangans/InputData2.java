package com.example.qeuangans;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class InputData2 extends AppCompatActivity {
    DatabaseHelper myDB;

    EditText jenispengeluaran, jmlpengeluaran;
    TextView tglpengeluaran;
    Button inputkeluar;
    private DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data2);

        final Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        myDB = new DatabaseHelper(this);

        jenispengeluaran = findViewById(R.id.jenispengeluaran);
        jmlpengeluaran = findViewById(R.id.jmlpengeluaran);
        tglpengeluaran = findViewById(R.id.tglpengeluaran);
        tglpengeluaran.setText(currentDate);
        inputkeluar = findViewById(R.id.inputkeluar);

        //KALENDER
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tglpengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datepickerdialog = new DatePickerDialog(InputData2.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datepickerdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datepickerdialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMont) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMont);
                String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
                tglpengeluaran.setText(date);
            }
        };
        //AKHIR KALENDER
        
        //pemanggilan method
        tambahData2();
    }

    private void tambahData2() {
        inputkeluar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInseted = myDB.insertData2(jmlpengeluaran.getText().toString(),
                                jenispengeluaran.getText().toString(), tglpengeluaran.getText().toString());
                        if (isInseted = true)
                            Toast.makeText(InputData2.this, "INPUT BERHASIL", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(InputData2.this, "INPUT GAGAL", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void pemasukan(View view) {
        Intent intent = new Intent(InputData2.this, InputData.class);
        startActivity(intent);

    }
}
