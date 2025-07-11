import java.util.List;
import java.util.stream.Collectors;

public class GeneradorReporte {
    private RepositorioMetodosLibro repositorio;

    public GeneradorReporte(RepositorioMetodosLibro repositorio) {
        this.repositorio = repositorio;
    }

    public void imprimirReporte() {
        System.out.println("\n==== Reporte de Libros ====");
        for (Libro l : repositorio.listarLibro()) {
            System.out.printf("ISBN: %s | Título: %s | Autor: %s | Año: %d | Disponible: %s\n",
                    l.getIsbn(), l.getTitulo(), l.getAutor(), l.getAnioPublicacion(),
                    l.isDisponible() ? "Sí" : "No");
        }
    }

    public void imprimirLibrosPorAutor(String autor) {
        System.out.println("\n==== Libros del autor: " + autor + " ====");
        List<Libro> librosPorAutor = repositorio.listarLibro().stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
        if (librosPorAutor.isEmpty()) {
            System.out.println("No se encontraron libros del autor especificado.");
        } else {
            for (Libro l : librosPorAutor) {
                System.out.printf("- %s (%d)%s\n", l.getTitulo(), l.getAnioPublicacion(), l.isDisponible() ? " [Disponible]" : " [Prestado]");
            }
        }
    }

}
