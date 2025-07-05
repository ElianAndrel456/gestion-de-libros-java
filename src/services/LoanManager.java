package services;

import err.LibraryException;
import model.Book;
import repositories.BookRepository;

public class LoanManager {
  private final BookRepository bookRepository;

  public LoanManager(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void loanBook(String isbn) {
    Book book = bookRepository.findBook(isbn);
    if (book == null)
      throw new LibraryException("El libro con ISBN " + isbn + " no existe.");
    if (!book.getIsAvailable())
      throw new LibraryException("El libro con ISBN " + isbn + " no está disponible para préstamo.");
    book.setIsAvailable(false);

  }

  public void returnBook(String isbn) {
    Book book = bookRepository.findBook(isbn);
    if (book == null)
      throw new LibraryException("El libro con ISBN " + isbn + " no existe.");
    if (book.getIsAvailable())
      throw new LibraryException("El libro con ISBN " + isbn + " no está prestado.");
    book.setIsAvailable(true);
  }

}