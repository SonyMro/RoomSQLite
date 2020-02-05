package com.example.room.Database;

import com.example.room.Entidades.Persona;
import com.example.room.Interfaces.PersonaDao;
import com.example.room.Interfaces.ProductoDao;
import com.example.room.Producto;
import androidx.room.Database;
import androidx.room.RoomDatabase;
//En esta clase vamos a declar nuestras tablas y entidadades siempre vamos a poner nuestras clase
//Entre llaves y la version de room en este caso es la uno
@Database(entities = {Persona.class, Producto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    @SuppressWarnings("WeakerAccess")//Con esta seleccionamos el tipo de permisos
    public abstract PersonaDao personaDao();

    public  abstract ProductoDao productoDao();

    private static AppDatabase sIntance;//Variable para llamar a nuestro base de datos
}
