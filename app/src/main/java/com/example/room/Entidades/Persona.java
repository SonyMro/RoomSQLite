package com.example.room.Entidades;

import android.content.ContentValues;
import android.provider.BaseColumns;

import androidx.room.*;
import androidx.room.PrimaryKey;

//En esta clase vamos a declara nuestra clase Persona y tambien la declaramos como entidad
@Entity(tableName = Persona.TABLA_NAME)
public class Persona {
    //Definimos el nombre de la tabla
    public static final String TABLA_NAME = "Persona";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ID = BaseColumns._ID;
    //Creamos nuestra Llave primaria y la ponemos como autoincrementable
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    public long id;
    //Creamos las columnas de nuestra tabla persona
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "apellido")
    private String apellido;
    @ColumnInfo(name = "dni")
    private String dni;
    @ColumnInfo(name = "edad")
    private String edad;

    //Encapsulamos nuestros atributos
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Ignore
    public Persona() {//Creamos un constructor vacio

    }  //Creamos un contructor en el cual vamos a pasar todos los datos de nuestra clase Persona

    public Persona(long id, String nombre, String apellido, String dni, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public static Persona fromContentValues(ContentValues values) {
        final Persona obj = new Persona();
        if (values.containsKey(COLUMN_ID)) {
            obj.id = values.getAsLong(COLUMN_ID);
        }
        if (values.containsKey(COLUMN_NAME)) {
            obj.setId(1);
        }
        return obj;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
