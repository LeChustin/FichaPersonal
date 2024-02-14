package com.chstn.fichapersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String estadoCivil = "soltero";

    DatabaseHelper myDb;
    EditText editNombre,editEdad, editTelefono, editDireccion, editCorreo;
    CheckBox checkBoxCasado;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editNombre = (EditText)findViewById(R.id.editTextNombre);
        editEdad = (EditText)findViewById(R.id.editTextEdad);
        btnAddData = (Button)findViewById(R.id.buttonGuardar);
        editTelefono = (EditText)findViewById(R.id.editTextTelefono);
        editDireccion = (EditText)findViewById(R.id.editTextDireccion);
        editCorreo = (EditText)findViewById(R.id.editTextCorreo);
        checkBoxCasado = findViewById(R.id.checkbox_casado);

        AddData();


        checkBoxCasado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Aquí puedes hacer algo cuando el estado del CheckBox cambia
                if (isChecked) {
                    // Si está marcado, asigna "casado" a la variable
                    estadoCivil = "casado";
                } else {
                    // Si no está marcado, asigna "soltero" a la variable
                    estadoCivil = "soltero";
                }
            }
        });

    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editNombre.getText().toString(),
                                editEdad.getText().toString(),
                                editTelefono.getText().toString(),
                                editDireccion.getText().toString(),
                                editCorreo.getText().toString(),
                                estadoCivil.toString());

                        if(isInserted)
                            Toast.makeText(MainActivity.this,"Datos Insertados", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Datos no insertados",Toast.LENGTH_LONG).show();

                        // Ir a la nueva vista
                        Intent intent = new Intent(MainActivity.this, presentacion.class);
                        startActivity(intent);
                    }
                }
        );
    }
}




