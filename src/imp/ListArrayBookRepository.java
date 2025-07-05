package imp;

import java.util.ArrayList;
import java.util.List;

import err.LibraryException;
import model.Book;
import repositories.BookRepository;

public class ListArrayBookRepository implements BookRepository {
  private List<Book> books = new ArrayList<Book>();

  @Override
  public void addBook(Book book) {
    Book existingBook = findBook(book.getISBN().toString());
    if (existingBook != null)
      throw new LibraryException("El libro con ISBN " + book.getISBN() + " ya existe.");

    books.add(book);
  }

  @Override
  public boolean removeBook(String isbn) {
    return books.removeIf(book -> book.getISBN().toString().equals(isbn));
  }

  @Override
  public Book findBook(String isbn) {
    return books.stream()
        .filter(book -> book.getISBN().toString().equals(isbn))
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<Book> listBooks() {
    return new ArrayList<>(books);
  }

}
