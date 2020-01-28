package com.example.qeuangans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class List2 extends AppCompatActivity {
    private static final String TAG ="List";

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        db = new DatabaseHelper(this);

        tampilkanDataKeluar();
    }

    private void tampilkanDataKeluar() {
        Cursor cursor = db.tampilkanDataKeluar();
        final SwipeMenuListView listView2 = findViewById(R.id.listView2);
        final ArrayList<String> listitem2 = new ArrayList<>();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "TIDAK ADA DATA", Toast.LENGTH_LONG).show();
        }else {
            while (cursor.moveToNext()){
                listitem2.add("\n" + "Tanggal : " + cursor.getString(3) + "\n" + "\n" + "Jenis Pemasukan : " + cursor.getString(1)
                        + "\n" + "Jumlah : Rp " + cursor.getString(2) + ",00" + "\n");

            }
            final ArrayAdapter adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listitem2);
            listView2.setAdapter(adapter2);

            SwipeMenuCreator creator = new SwipeMenuCreator() {

                @Override
                public void create(SwipeMenu menu) {
                    // create "open" item
                    SwipeMenuItem openItem = new SwipeMenuItem(
                            getApplicationContext());
                    // set item background
                    openItem.setBackground(new ColorDrawable(Color.rgb(255, 33,
                            33)));
                    // set item width
                    openItem.setWidth(170);
                    // set item title
                    openItem.setTitle("Hapus");
                    // set item title fontsize
                    openItem.setTitleSize(18);
                    // set item title font color
                    openItem.setTitleColor(Color.WHITE);
                    // add to menu
                    menu.addMenuItem(openItem);
                }
            };
            listView2.setMenuCreator(creator);



            listView2.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {
                    switch (index) { //ini
                        case 0:
                            Toast.makeText(List2.this, "INPUT BERHASIL", Toast.LENGTH_LONG).show();
                    }
                    // false : close the menu; true : not close the menu
                    return false;
                }
            });

        }
    }
}
