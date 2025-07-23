package com.libreria.libreria;

import java.util.ArrayList;
import java.util.List;

import com.libreria.libreria.models.Libro;

class ArrayListaLibroRepositorio implements RepositorioMetodosLibro {
    private List<Libro> libros = new ArrayList<>();

    @Override
    public void agregarLibro(Libro libro) throws ExcepcionBiblioteca {
        for (Libro l : libros) {
            if (l.getIsbn().equals(libro.getIsbn())) {
                throw new ExcepcionBiblioteca("ISBN duplicado");
            }
        }
        libros.add(libro);
    }

    @Override
    public void eliminarLibro(String isbn) throws ExcepcionBiblioteca {
        Libro libro = buscarLibro(isbn);
        libros.remove(libro);
    }

    @Override
    public Libro buscarLibro(String isbn) throws ExcepcionBiblioteca {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        throw new ExcepcionBiblioteca("El libro no fue encontrado");
    }

    @Override
    public List<Libro> listarLibro() {
        return libros;
    }
}