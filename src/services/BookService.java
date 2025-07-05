package services;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import repositories.BookFilterRepository;
import repositories.BookRepository;

public class BookService {
  private final BookRepository repository;

  public BookService(BookRepository repository) {
    this.repository = repository;
  }

  public List<Book> filterBooks(BookFilterRepository filtro) {
    List<Book> resultado = new ArrayList<>();
    for (Book book : repository.listBooks()) {
      if (filtro.filter(book)) {
        resultado.add(book);
      }
    }
    return resultado;
  }

}
