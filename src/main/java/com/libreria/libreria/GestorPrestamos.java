package com.libreria.libreria;

import com.libreria.libreria.models.Libro;

public class GestorPrestamos {
    private RepositorioMetodosLibro repositorio;

    public GestorPrestamos(RepositorioMetodosLibro repositorio) {
        this.repositorio = repositorio;
    }

    public void prestarLibro(String isbn) throws ExcepcionBiblioteca {
        Libro libro = repositorio.buscarLibro(isbn);
        if (!libro.isDisponible())
            throw new ExcepcionBiblioteca("Libro ya prestado");
        libro.setDisponible(false);
    }

    public void devolverLibro(String isbn) throws ExcepcionBiblioteca {
        Libro libro = repositorio.buscarLibro(isbn);
        libro.setDisponible(true);
    }

}
