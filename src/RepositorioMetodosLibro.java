import java.util.List;

//Creación de una interfaz
interface RepositorioMetodosLibro{
    void agregarLibro(Libro libro);
    void eliminarLibro(String isbn);
    Libro buscarLibro(String isbn);
    List<Libro> listarLibro();
}