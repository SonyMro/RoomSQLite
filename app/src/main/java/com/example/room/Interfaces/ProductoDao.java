package com.example.room.Interfaces;

import com.example.room.Producto;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
//En esta interfas vamos escribir los metodo que van a interactuar con la base de datos
//Dao Data access object
@Dao
public interface ProductoDao {
    //Utilizaremos el query para poder hacer consultas o para escribir codigo de SQLite
    //Cada consulta nos va a retorna algo
    @Query("SELECT COUNT(*) FROM"+ Producto.TABLE_NAME)
    int Count();
    //Hacemos una consulata para reurperar todos nuestros registros
    @Query("SELECT * FROM "+Producto.TABLE_NAME)
    List<Producto> getAlProductos();
    //Con el Insert insertaremos un nuevo registro
    @Insert
    void  insertaAll(Producto ...products);

    /*@Query("DELETE FROM "+Producto.TABLE_NAME+" WHERE "+Producto.CUlUMN_ID+":ide")
    int deleteById(long ide);*/

}
