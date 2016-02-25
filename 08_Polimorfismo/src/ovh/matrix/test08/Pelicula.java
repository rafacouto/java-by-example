package ovh.matrix.test08;

/**
 * Created by caligari on 23/02/2016.
 */
public class Pelicula {

    private static String ARGUMENTO_DEFAULT = "-sin argumento-";

    private String titulo;
    private String argumento;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public Pelicula(String titulo) {
        this.titulo = titulo;
        this.argumento = ARGUMENTO_DEFAULT;
    }
}
