package imp;

import java.util.ArrayList;
import java.util.List;

import err.LibraryException;
import model.Book;
import repositories.BookRepository;

public class ArrayBookRepository implements BookRepository {
  private static final int MAX_BOOKS = 100;
  private Book[] books = new Book[MAX_BOOKS];
  private int bookCount = 0;

  @Override
  public void addBook(Book book) {
    Book existingBook = findBook(book.getISBN().toString());

    if (existingBook != null)
      throw new LibraryException("El libro con ISBN " + book.getISBN() + " ya existe.");

    if (bookCount < MAX_BOOKS) {
      books[bookCount++] = book;
    } else {
      throw new LibraryException("No se pueden agregar más libros");
    }
  }

  @Override
  public boolean removeBook(String isbn) {
    for (int i = 0; i < bookCount; i++) {
      if (books[i].getISBN().equals(isbn)) {
        books[i] = books[--bookCount];
        books[bookCount] = null;
        return true;
      }
    }
    return false;
  }

  @Override
  public Book findBook(String isbn) {
    for (int i = 0; i < bookCount; i++) {
      if (books[i].getISBN().equals(isbn)) {
        return books[i];
      }
    }
    return null;
  }

  @Override
  public List<Book> listBooks() {
    List<Book> bookList = new ArrayList<>();
    for (int i = 0; i < bookCount; i++) {
      bookList.add(books[i]);
    }
    return bookList;
  }

}
