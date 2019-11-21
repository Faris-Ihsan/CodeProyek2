package com.example.qeuangans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InputData2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data2);
    }

    public void pemasukan(View view) {
        Intent intent = new Intent(InputData2.this, InputData.class);
        startActivity(intent);
    }
}
