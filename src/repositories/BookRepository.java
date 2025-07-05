package repositories;

import java.util.List;

import model.Book;

public interface BookRepository {

  void addBook(Book book);

  boolean removeBook(String isbn);

  Book findBook(String isbn);

  List<Book> listBooks();

}
