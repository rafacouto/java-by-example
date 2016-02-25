package ovh.matrix.test12;

/**
 * Created by caligari on 2/24/16.
 */
public class Socio extends Persona {

    int numero;

    public int getNumero() {
        return numero;
    }

    public Socio(String nombre, int numero) {
        super(nombre);
        this.numero = numero;
    }
}
