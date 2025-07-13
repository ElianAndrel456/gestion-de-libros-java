import java.util.List;
import java.util.stream.Collectors;

public class GeneroLibroFiltro implements LibroFiltro{
    private String genero;

    public GeneroLibroFiltro(String genero) {
        this.genero = genero;
    }

    @Override
    public List<Libro> filter(List<Libro> libros) {
        return libros.stream()
                .filter(l -> l.getGenero().equals(this.genero))
                .collect(Collectors.toList());
    }

    @Override
    public Libro[] filter(Libro[] libros) {
        int count = 0;
        for (Libro libro : libros) {
            if (libro.getGenero().equals(this.genero)) {
                count++;
            }
        }

        Libro[] filteredLibros = new Libro[count];
        int idx = 0;
        for (Libro libro : libros) {
            if (libro.getGenero().equals(this.genero)) {
                filteredLibros[idx++] = libro;
            }
        }

        return filteredLibros;
    }
}
