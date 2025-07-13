import java.util.List;

public class Biblioteca {
    private RepositorioMetodosLibro repositorio;
    private GestorPrestamos gestorPrestamos;
    private GeneradorReporte generadorReporte;

    public Biblioteca(RepositorioMetodosLibro repositorio) {
        this.repositorio = repositorio;
        this.gestorPrestamos = new GestorPrestamos(repositorio);
        this.generadorReporte = new GeneradorReporte(repositorio);
    }

    public void agregarLibro(Libro libro) throws ExcepcionBiblioteca {
        repositorio.agregarLibro(libro);
    }

    public void eliminarLibro(String isbn) throws ExcepcionBiblioteca {
        repositorio.eliminarLibro(isbn);
    }

    public void prestarLibro(String isbn) throws ExcepcionBiblioteca {
        gestorPrestamos.prestarLibro(isbn);
    }

    public void devolverLibro(String isbn) throws ExcepcionBiblioteca {
        gestorPrestamos.devolverLibro(isbn);
    }

    public void imprimirReporte() {
        generadorReporte.imprimirReporte();
    }

    public List<Libro> obtenerLibros() {
        return repositorio.listarLibro();
    }

    public String imprimirLibrosPorFiltro(LibroFiltro filtro) {
        return generadorReporte.imprimirLibrosPorAutor(filtro);
    }

}
