package com.example.room;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.room.Config.Contantes;
import com.example.room.Database.AppDatabase;
import com.example.room.Entidades.Persona;

/*En esta clase o vamos obtener vamos a ejecutar las operciones de Actualizar y Eliminar*/
public class UpdatePersona extends AppCompatActivity {
    /*Declaramos nuestros componentes*/
    private EditText txtNombre, txtape, txtEdad, txtdni;
    private TextView lblId;
    private Button btnElimnar, btnUpdate;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_persona);
        Toast.makeText(UpdatePersona.this, getIntent().getStringExtra("id"), Toast.LENGTH_SHORT).show();
        lblId = (TextView) findViewById(R.id.lblIDU);
        lblId.setText(getIntent().getStringExtra("id"));
        txtNombre = (EditText) findViewById(R.id.txtNombreU);
        txtNombre.setText(getIntent().getStringExtra("nombre"));
        txtape = (EditText) findViewById(R.id.txtApeU);
        txtape.setText(getIntent().getStringExtra("apellido"));
        txtdni = (EditText) findViewById(R.id.txtdniU);
        txtdni.setText(getIntent().getStringExtra("dni"));
        txtEdad = (EditText) findViewById(R.id.txtEdadU);
        txtEdad.setText(getIntent().getStringExtra("Edad"));
        btnUpdate = (Button) findViewById(R.id.btnMod);
        btnElimnar = (Button) findViewById(R.id.btnDelete);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = Integer.parseInt(lblId.getText().toString());
                String nombre = txtNombre.getText().toString();
                String apellidos = txtape.getText().toString();
                String Dni = txtdni.getText().toString();
                String Edad = txtEdad.getText().toString();
                final Persona ModPersona = new Persona(id, nombre, apellidos, Dni, Edad);

                AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePersona.this);
                builder.setTitle("Alerta");
                builder.setMessage("¿Deseas actualizar a:?" + nombre);

                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ModificarPersona(ModPersona);
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UpdatePersona.this, "Actualizacion cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btnElimnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePersona.this);
                builder.setTitle("Confirma");
                builder.setMessage("¿Deseas eliminar a: ?" + txtNombre.getText().toString());

                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EliminarPersona(Integer.parseInt(String.valueOf(lblId.getText())));

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UpdatePersona.this, "Elimnacion cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    public void EliminarPersona(int IdPersona) {
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Contantes.BD_NAME).allowMainThreadQueries().build();
        //toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);

        if (IdPersona != 0) {
            db.personaDao().deleteById(IdPersona);
            Toast.makeText(UpdatePersona.this, "Usuario Eliminado", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(UpdatePersona.this, "Este usuarios no existe", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(new Intent(UpdatePersona.this, MostrarLista.class));
        startActivity(intent);

        // Toast.makeText(UpdatePersona.this,"Hola",Toast.LENGTH_SHORT).show();
    }

    public void ModificarPersona(Persona up) {
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Contantes.BD_NAME).allowMainThreadQueries().build();
        if (up != null) {
            db.personaDao().updateEntidad(up);
            Toast.makeText(UpdatePersona.this, "Usuario Actualizado", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(UpdatePersona.this, "Verifique que este usuario exista", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(new Intent(UpdatePersona.this, MostrarLista.class));
        startActivity(intent);
    }

}
