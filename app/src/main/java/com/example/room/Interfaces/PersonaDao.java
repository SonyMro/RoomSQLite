package com.example.room.Interfaces;

import com.example.room.Entidades.Persona;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
//En esta interfas vamos escribir los metodo que van a interactuar con la base de datos
//Dao Data access object
@Dao
public interface PersonaDao {
    //Utilizaremos el query para poder hacer consultas o para escribir codigo de SQLite
    //Cada consulta nos va a retorna algo
    @Query("SELECT COUNT(*) FROM "+ Persona.TABLA_NAME)
    int count();//metodo nos devuelve la cantidad de regsitros
    //Con el Insert insertaremos un nuevo registro
    @Insert
    void insertAll(Persona ...usuarios);
    //Es un void por que no nos devolvera nada

    //Para el delete hacemos una consulata y esta nos devolvera la cantidad de registros en la base de datos
    @Query("DELETE FROM "+Persona.TABLA_NAME+" WHERE "+Persona.COLUMN_ID+"=:ide")
    int deleteById(int ide);
    //Para actualizar ulizaremos el Update el cual es necesario que le pasamos como parametro un objeto
    @Update
    int updateEntidad(Persona obj);//No retorna la cantidad
    //A direcnia del anterio este al insertar nos devuelve la candidade de registro en la base de datos
    @Insert
    long insert(Persona person);
    //Hacemos una consulata para reurperar todos nuestros registros
    @Query("SELECT * FROM "+Persona.TABLA_NAME)
    List<Persona> getAllPersonas();//Este nos retornara una List<> de personas
}
