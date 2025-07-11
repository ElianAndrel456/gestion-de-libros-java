import java.util.ArrayList;
import java.util.List;

class ArrayLibroRepositorio implements RepositorioMetodosLibro{
    private Libro[] libros;
    private int tamano;
    
    public ArrayLibroRepositorio(int capacidad){
        libros = new Libro[capacidad];
        tamano = 0;
    }

    @Override
    public void agregarLibro(Libro libro) throws ExcepcionBiblioteca{
        if(tamano>=libros.length){
            throw new ExcepcionBiblioteca("No hay espacio para más libros");
        }
        for(int i=0; i<tamano; i++){
            if(libros[i].getIsbn().equals(libro.getIsbn())){
                throw new ExcepcionBiblioteca("ISBN duplicado");
            };
        }
        libros[tamano] = libro;
        tamano++;
    }

    @Override
    public void eliminarLibro(String isbn) throws ExcepcionBiblioteca{
        boolean encontrado = false;
        for(int i=0; i<tamano; i++){
            if(libros[i].getIsbn().equals(isbn)){
                for(int j=i; j<tamano-1; j++){
                    libros[j] = libros[j+1];
                }
            libros[tamano-1]=null;
            tamano--;
            encontrado = true;
            }
        }
        if(!encontrado){
            throw new ExcepcionBiblioteca("Libro no encontrado");
        }
    }

    @Override
    public Libro buscarLibro(String isbn) throws ExcepcionBiblioteca{
        for(int i=0; i<tamano; i++){
            if(libros[i].getIsbn().equals(isbn)){
                return libros[i];
            };
        }
        throw new ExcepcionBiblioteca("El libro no fue encontrado");
    }

    @Override
    public List<Libro> listarLibro(){
        List<Libro> resultado = new ArrayList<>();
        for(int i=0; i<tamano; i++){
            resultado.add(libros[i]);
        }
        return resultado;
    }
}