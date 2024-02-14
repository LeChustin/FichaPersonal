package com.chstn.fichapersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editNombre, editEdad;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editNombre = (EditText)findViewById(R.id.editTextNombre);
        editEdad = (EditText)findViewById(R.id.editTextEdad);
        btnAddData = (Button)findViewById(R.id.buttonGuardar);

        AddData();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editNombre.getText().toString(),
                                editEdad.getText().toString());
                        if(isInserted)
                            Toast.makeText(MainActivity.this,"Datos Insertados", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Datos no insertados",Toast.LENGTH_LONG).show();

                        // Ir a la nueva vista
                        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}




