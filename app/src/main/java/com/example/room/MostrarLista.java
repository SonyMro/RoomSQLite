package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.room.Adaptadores.AdpPersona;
import com.example.room.Config.Contantes;
import com.example.room.Database.AppDatabase;
import com.example.room.Entidades.Persona;

import java.util.ArrayList;
import java.util.List;
/*En esta clase Llenamos nuestro ListView*/
public class MostrarLista extends AppCompatActivity {
    //Declaramos un ListView para relacionarlo con la interfaz
    private ListView listView;
    //Instancimos nuestra base de datos
    private AppDatabase db;
    //Creamos un List para obener todos los registro de nuestra base de datos.
    private List<Persona> listPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        //Relacionamos nuestro list con el del la interfaz
        listView = (ListView) findViewById(R.id.listaView);
        //Intancimos nuesta clase appdatabase
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Contantes.BD_NAME).allowMainThreadQueries().build();
        //Llenamos nuestro List con todos los registros de la base de datos
        listPersonas = db.personaDao().getAllPersonas();
        //Creamos un evento click de cada item para poder editar
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //No redirigimos a la calse listaPersonas
                IrInformacionPersona(listPersonas.get(position));
            }
        });
        //Llamanos a la clase AdpPersona la cual tiene nuestro adaptador para nuestro ListView
        AdpPersona adpPersona = new AdpPersona(this, R.layout.item_persona, listPersonas);
       //Inicializamos ListView
        listView.setAdapter(adpPersona);
    }
    /*Este metodo nos ayudara a pasar un objeto a otro activuty como parametro le pasamos un objeto persona*/
    public void IrInformacionPersona(Persona pUp) {
        /*Creamos un itennt que apunte a la clase UpdatePersona*/
        Intent UpPersona = new Intent(MostrarLista.this, UpdatePersona.class);
        /*Con el metodo putextra pasamos los valores del activity acuatual a la que nos vamos a dirigir*/
        UpPersona.putExtra("id", pUp.id + "");
        //el Primer parametro es la key y el segundo es el valor
        UpPersona.putExtra("nombre", pUp.getNombre() + "");
        UpPersona.putExtra("apellido", pUp.getApellido() + "");
        UpPersona.putExtra("dni", pUp.getDni() + "");
        UpPersona.putExtra("Edad", pUp.getEdad() + "");
        startActivity(UpPersona);
    }
}
