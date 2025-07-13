import java.util.List;

public interface LibroFiltro {
    List<Libro> filter(List<Libro> Libros);
    Libro[] filter(Libro[] Libros);
}
