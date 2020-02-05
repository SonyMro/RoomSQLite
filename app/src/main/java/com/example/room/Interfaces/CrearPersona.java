package com.example.room.Interfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room.Database.AppDatabase;
import com.example.room.Config.Contantes;
import com.example.room.Entidades.Persona;
import com.example.room.MainActivity;
import com.example.room.R;
/*En esta clase vamos a recolectar los datos del formulario y los almacenaremos en la base de datos*/
public class CrearPersona extends AppCompatActivity {

    //Varibles que se obtinen con el xlm
    private EditText txtNombre, txtApellido, txtDNI, txtEdad;
    //Intanciomos nuestra clase AppDatabase
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
        //Obtnemos todos los valores de nuestro formulario
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtDNI = (EditText) findViewById(R.id.txtDNI);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        // Intancia la db o llamar
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Contantes.BD_NAME).allowMainThreadQueries().build();
    }
    //Este medodo lo llamanos en la propiedade el boton en el xlm
    public void InsertarPersona(View view) {
        Persona obj = new Persona();
        obj.setNombre(txtNombre.getText().toString());
        obj.setApellido(txtApellido.getText().toString());
        obj.setEdad(txtEdad.getText().toString());
        obj.setDni(txtDNI.getText().toString());
        //Insertar en la db Dao
        long resultado = db.personaDao().insert(obj);
        if (resultado > 0) {//Si el se inserto correctamente nos redigira al mainPrincipar
            startActivity(new Intent(CrearPersona.this, MainActivity.class));

        } else {//Si hay un error imprimimos una alerta
            Toast.makeText(CrearPersona.this, "Hay un error", Toast.LENGTH_SHORT).show();
        }

    }
}
