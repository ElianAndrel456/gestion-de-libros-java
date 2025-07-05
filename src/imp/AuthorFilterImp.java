package imp;

import model.Book;
import repositories.BookFilterRepository;

public class AuthorFilterImp implements BookFilterRepository {
  private final String author;

  public AuthorFilterImp(String author) {
    this.author = author;
  }

  @Override
  public boolean filter(Book book) {
    return book.getAuthor().equalsIgnoreCase(author);
  }
}
