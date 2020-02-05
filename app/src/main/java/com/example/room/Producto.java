package com.example.room;

import android.provider.BaseColumns;

import com.example.room.Entidades.Persona;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Producto.TABLE_NAME)
public class Producto {
    public  static  final String TABLE_NAME="producto";
    public static final String COLUMN_NAME="name";
    public static final String CUlUMN_ID= BaseColumns._ID;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index=true,name = CUlUMN_ID)
    private long id;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "Categoria")
    private String categoria;
    @ColumnInfo(name = "precio")
    private float precio;

    public Producto(long id, String nombre, String categoria, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


}
