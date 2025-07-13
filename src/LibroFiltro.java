import java.util.List;

public interface LibroFiltro {
    List<? extends Libro> filter(List<Libro> Libros);
    Libro[] filter(Libro[] Libros);
}
