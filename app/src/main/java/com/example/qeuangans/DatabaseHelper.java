package com.example.qeuangans;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Qeuangan.db";
    public static final String TBLNAME = "pemasukan";
    public static final String TBLNAME2 = "pengeluaran";
    public static final String COL1 = "ID_PEMASUKAN";
    public static final String COL8 = "ID_PENGELUARAN";
    public static final String COL2 = "JENIS_PEMASUKAN";
    public static final String COL3 = "PEMASUKAN";
    public static final String COL4 = "JENIS_PENGELUARAN";
    public static final String COL5 = "PENGELUARAN";
    public static final String COL6 = "TANGGAL_PEMASUKAN";
    public static final String COL7 = "TANGGAL_PENGELUARAN";


    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TBLNAME +"(ID_PEMASUKAN INTEGER PRIMARY KEY AUTOINCREMENT, JENIS_PEMASUKAN STRING," +
                "PEMASUKAN NUMBER, TANGGAL_PEMASUKAN STRING)");

        db.execSQL("create table "+ TBLNAME2 +"(ID_PENGELUARAN INTEGER PRIMARY KEY AUTOINCREMENT, JENIS_PENGELUARAN STRING," +
                "PENGELUARAN NUMBER, TANGGAL_PENGELUARAN STRING)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TBLNAME);
        db.execSQL("DROP TABLE IF EXISTS "+TBLNAME2);
        onCreate(db);
    }

    //UNTUK INPUT DATA
    public boolean insertData(String jenis_pemasukan, String pemasukan, String tanggal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, jenis_pemasukan);
        contentValues.put(COL3, pemasukan);
        contentValues.put(COL6, tanggal);

        long result = db.insert(TBLNAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    //SCRIPT MENAMPILKAN DATA PEMASUKAN
    public Cursor tampilkanData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res;
        res = db.rawQuery("SELECT * FROM "+TBLNAME,null);
        return res;
    }

    public Cursor tampilkanDataKeluar() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res;
        res = db.rawQuery("SELECT * FROM "+TBLNAME2,null);
        return res;
    }

    public boolean insertData2(String pengeluaran, String jenis_pengeluaran, String tanggal_pengeluaran) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL5, pengeluaran);
        values.put(COL4, jenis_pengeluaran);
        values.put(COL7, tanggal_pengeluaran);

        long result = db.insert(TBLNAME2, null, values);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor totalPemasukan(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor saldo;
        saldo = db.rawQuery("SELECT SUM("+COL3+") as Total1 FROM "+TBLNAME,null);
        saldo.moveToFirst();
        saldo.getInt(saldo.getColumnIndex("Total1"));
        return saldo;
    }

    public Cursor totalPengeluaran(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor saldo;
        saldo = db.rawQuery("SELECT SUM("+COL5+") as Total2 FROM "+TBLNAME2,null);
        saldo.moveToFirst();
        saldo.getInt(saldo.getColumnIndex("Total2"));
        return saldo;
    }


    /**
    public Cursor saldo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor saldo;
        saldo = db.rawQuery("SELECT SUM(" +COL3+")-SUM(" +COL5+") FROM "+TBLNAME, null);
        return saldo;
    }***/
}
