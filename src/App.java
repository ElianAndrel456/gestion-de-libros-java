
public class App {
    public static void main(String[] args) throws Exception {
        try {
            Biblioteca biblioteca = new Biblioteca(new ArrayListaLibroRepositorio());

            Libro l1 = new Libro("001", "Java Básico", "Juan Pérez", "Programación", 2020);
            Libro l2 = new Libro("002", "Spring Boot", "Ana Torres", "Frameworks", 2021);
            Libro l3 = new Libro("003", "Estructuras de Datos", "Juan Pérez", "Algoritmos", 2019);
            Libro l4 = new Libro("004", "Microservicios", "Ana Torres", "Arquitectura", 2022); // Nuevo libro

            biblioteca.agregarLibro(l1);
            biblioteca.agregarLibro(l2);
            biblioteca.agregarLibro(l3);
            biblioteca.agregarLibro(l4);

            biblioteca.prestarLibro("002");

            try {
                biblioteca.prestarLibro("002");
            } catch (ExcepcionBiblioteca e) {
                System.out.println("Excepción esperada: " + e.getMessage());
            }

            // Reporte general
            biblioteca.imprimirReporte();

            // Reporte por autor
            System.out.println(biblioteca.imprimirLibrosPorAutor(new AutorLibroFiltro("Juan Pérez")));;
            System.out.println(biblioteca.imprimirLibrosPorAutor(new AutorLibroFiltro("Ana Torres")));;

            // Autor sin libros
            System.out.println(biblioteca.imprimirLibrosPorAutor(new AutorLibroFiltro("Autor Desconocido")));;

        } catch (ExcepcionBiblioteca e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
