package com.chstn.fichapersonal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Personas.db";
    private static final String TABLE_NAME = "persona_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NOMBRE";
    private static final String COL_3 = "EDAD";

    private static final String COL_4 = "TELEFONO";

    private static final String COL_5 = "DIRECCION";
    private static final String COL_6 = "CORREO";
    private static final String COL_7 = "ESTADO";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOMBRE TEXT, EDAD INTEGER, TELEFONO TEXT, DIRECCION TEXT, " +
                "CORREO TEXT, ESTADO TEXT)");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nombre, String edad, String telefono, String direccion, String correo, String estado) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, edad);
        contentValues.put(COL_4, telefono);
        contentValues.put(COL_5, direccion);
        contentValues.put(COL_6, correo);
        contentValues.put(COL_7, estado);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Método para recuperar los datos
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}