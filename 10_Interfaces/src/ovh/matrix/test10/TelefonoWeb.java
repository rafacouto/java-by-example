package ovh.matrix.test10;

/**
 * Created by caligari on 2/24/16.
 */
public class TelefonoWeb implements ITelefono {

    int numero;
    boolean estaSonando;

    public TelefonoWeb(int numero) {
        this.numero = numero;
    }

    @Override
    public void activar() {

    }

    @Override
    public void llamar(int numero) {

    }

    @Override
    public void responder() {

    }

    @Override
    public boolean estaSonando() {
        return this.estaSonando;
    }
}
