package repositories;

import model.Book;

public interface BookFilterRepository {
  boolean filter(Book book);

}
