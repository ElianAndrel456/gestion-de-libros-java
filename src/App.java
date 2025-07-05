
import imp.ListArrayBookRepository;
import model.Book;
import services.LoanManager;

public class App {
    public static void main(String[] args) throws Exception {
        /* CREACION DE LIBROS */
        Book book1 = new Book("001", "El Señor de los Anillos", "J.R.R. Tolkien", 1954, true);
        Book book2 = new Book("002", "El Quijote", "Cervantes", 1605, true);
        Book book3 = new Book("003", "Clean Architecture", "Robert C. Martin", 2017, true);
        Book book4 = new Book("004", "Effective Java", "Joshua Bloch", 2018, true);
        Book book5 = new Book("005", "Java Concurrency in Practice", "Brian Goetz", 2006, true);
        Book book6 = new Book("006", "Design Patterns", "Erich Gamma", 1994, true);

        ListArrayBookRepository repo = new ListArrayBookRepository();
        LoanManager loan = new LoanManager(repo);

        try {
            repo.addBook(book1);
            repo.addBook(book2);
            repo.addBook(book3);
            repo.addBook(book4);
            repo.addBook(book5);
            repo.addBook(book6);

            // Prestar un libro
            System.out.println("Prestando libro 001...");
            loan.loanBook("001");
            loan.loanBook("002");
            // Intentar prestarlo otra vez (error)
            System.out.println("Intentando volver a prestar 001...");
            loan.loanBook("001");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Devolviendo libro 001...");
            loan.returnBook("001");

            System.out.println("Libros finales:");
            for (Book l : repo.listBooks()) {
                System.out.printf("- %s (%s) [%s]%n", l.getTitle(), l.getAuthor(),
                        l.getIsAvailable() ? "Disponible" : "Prestado");
            }
        } catch (Exception e) {
            System.err.println(" Error: " + e.getMessage());
        }

    }
}
