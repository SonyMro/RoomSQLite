package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.room.Config.Contantes;
import com.example.room.Database.AppDatabase;
import com.example.room.Entidades.Persona;
import com.example.room.Interfaces.CrearPersona;

import java.util.List;

/*En esta es la principal*/
public class MainActivity extends AppCompatActivity {

    //intancia de la base de datos
    private AppDatabase db;
    //Declaramos nuestro boton listar
    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Relacionamos nuestro boton con el de la interfaz
        btnListar = (Button) findViewById(R.id.btnListar);
        //Creamos el evento click
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Nos dirigimos al Activity de MostrarLista
                Intent intent = new Intent(MainActivity.this, MostrarLista.class);
                startActivity(intent);
            }
        });

    }
    //Este metodo los ejecutamos en el el xml con la propiedade del boton de Crear persona
    public void CrearPersona(View view) {
        startActivity(new Intent(MainActivity.this, CrearPersona.class));
        }

    public void ToasPersonalizado() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        TextView text = (TextView) layout.findViewById(R.id.txtToast);
        text.setText("This is a custom toast");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
}
