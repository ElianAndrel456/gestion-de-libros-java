import java.util.List;
import java.util.stream.Collectors;

public class AutorLibroFiltro implements LibroFiltro{
    private String autor;

    public AutorLibroFiltro(String autor) {
        this.autor = autor;
    }

    @Override
    public List<Libro> filter(List<Libro> Libros) {
        return Libros.stream()
                .filter(b -> b.getAutor().equals(this.autor))
                .collect(Collectors.toList());
    }

    @Override
    public Libro[] filter(Libro[] Libros) {
        int counter = 0;
        for (Libro Libro : Libros) {
            if(Libro.getIsbn().equals(this.autor)) {
                counter++;
            }
        }

        Libro[] filteredLibros = new Libro[counter];
        counter = 0;

        for (Libro Libro : Libros) {
            if(Libro.getIsbn().equals(this.autor)) {
                filteredLibros[counter++] = Libro;
            }
        }
        return filteredLibros;
    }
}
