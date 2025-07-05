package model;

enum EBookFormat {
  PDF, WORK, AUDIOBOOK, COMIC
}

public class EBook extends Book {

  private EBookFormat format;

  public EBook(String ISBN, String title, String author, int year, Boolean isAvailable, EBookFormat format) {
    super(ISBN, title, author, year, isAvailable);
    if (format == null)
      throw new IllegalArgumentException("El formato del libro electrónico no puede ser nulo");
    this.format = format;
  }

  public EBookFormat getFormat() {
    return format;
  }

  public void setFormat(EBookFormat format) {
    if (format == null)
      throw new IllegalArgumentException("El formato del libro electrónico no puede ser nulo");
    this.format = format;
  }

}
