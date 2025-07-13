import java.util.List;

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

    public String imprimirLibrosPorAutor(LibroFiltro filtro) {
        List<Libro> allBooks = repositorio.listarLibro();
        List<? extends Libro> filtrado = filtro.filter(allBooks);

        if (filtrado.isEmpty()) {
            return "No hay libros que coincidan con el filtro: "
                    + filtro.getClass().getSimpleName();
        }

        StringBuilder report = new StringBuilder("=== Reporte Filtrado (")
                .append(filtro.getClass().getSimpleName())
                .append(") ===\n");

        for (Libro libro : filtrado) {
            report.append(String.format(
                    "%s (%d) por %s [ISBN: %s] - %s\n",
                    libro.getTitulo(),
                    libro.getAnioPublicacion(),
                    libro.getAutor(),
                    libro.getIsbn(),
                    libro.isDisponible() ? "Disponible" : "Prestado"
            ));
        }

        report.append("Total: ")
                .append(filtrado.size())
                .append(filtrado.size() == 1 ? " libro\n" : " libros\n");

        return report.toString();
    }

}
