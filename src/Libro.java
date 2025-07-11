
public class Libro {
  private String isbn;
  private String titulo;
  private String autor;
  private String genero;
  private int anioPublicacion;
  private boolean disponible = true;

  public Libro(String isbn, String titulo, String autor, String genero, int anioPublicacion) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.anioPublicacion = anioPublicacion;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getGenero() {
    return genero;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public int getAnioPublicacion() {
    return anioPublicacion;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public void setAnioPublicacion(int anioPublicacion) {
    this.anioPublicacion = anioPublicacion;
  }

  public boolean isDisponible() { return disponible; }
  public void setDisponible(boolean disponible) { this.disponible = disponible; }

  @Override
  public String toString() {
    return titulo + " - " + autor + " (" + anioPublicacion + ")";
  }
}
