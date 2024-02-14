package com.chstn.fichapersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class presentacion extends AppCompatActivity {

    DatabaseHelper myDb;
    TextView textViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        myDb = new DatabaseHelper(this);
        textViewDatos = (TextView)findViewById(R.id.textViewDatos);

        showData();
    }

    private void showData() {
        Cursor res = myDb.getAllData();
        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            buffer.append("Hola soy ").append(res.getString(1)).append(", mi edad es ").append(res.getString(2)).append("\n");
        }
        textViewDatos.setText(buffer.toString());
    }
}