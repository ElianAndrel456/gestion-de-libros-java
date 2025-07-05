package model;

public class Book {
  private String ISBN;
  private String title;
  private String author;
  private int year;
  private Boolean isAvailable;

  public Book(String ISBN, String title, String author, int year, Boolean isAvailable) {
    if (ISBN == null || ISBN.toString().isEmpty())
      throw new IllegalArgumentException("ISBN no puede ser nulo o vacío");
    if (title == null || title.isEmpty())
      throw new IllegalArgumentException("El título no puede ser nulo o vacío");
    if (author == null || author.isEmpty())
      throw new IllegalArgumentException("El autor no puede ser nulo o vacío");
    if (year <= 0)
      throw new IllegalArgumentException("El año debe ser positivo");
    if (isAvailable == null)
      throw new IllegalArgumentException("El estado de disponibilidad debe ser proporcionado");

    this.ISBN = ISBN;
    this.title = title;
    this.author = author;
    this.year = year;
    this.isAvailable = isAvailable;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    if (year <= 0)
      throw new IllegalArgumentException("El año debe ser positivo");
    this.year = year;
  }

  public Boolean getIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

}