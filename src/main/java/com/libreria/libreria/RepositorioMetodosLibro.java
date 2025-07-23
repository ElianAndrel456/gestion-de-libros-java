package com.libreria.libreria;

import java.util.List;

import com.libreria.libreria.models.Libro;

//Creación de una interfaz
interface RepositorioMetodosLibro {
    void agregarLibro(Libro libro) throws ExcepcionBiblioteca;

    void eliminarLibro(String isbn) throws ExcepcionBiblioteca;

    Libro buscarLibro(String isbn) throws ExcepcionBiblioteca;

    List<Libro> listarLibro();
}