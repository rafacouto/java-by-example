package ovh.matrix.test12;

/**
 * Created by caligari on 2/24/16.
 */
public abstract class Jugador extends Persona {

    int dorsal;

    public int getDorsal() {
        return dorsal;
    }

    public Jugador(String nombre, int dorsal) {
        super(nombre);
        this.dorsal = dorsal;
    }

    abstract public void jugar();
}
