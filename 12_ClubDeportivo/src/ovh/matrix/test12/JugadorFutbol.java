package ovh.matrix.test12;

/**
 * Created by caligari on 2/24/16.
 */
public class JugadorFutbol extends Jugador {

    public static final int POSICION_PORTERO = 1;
    public static final int POSICION_DEFENSA = 2;
    public static final int POSICION_MEDIO = 3;
    public static final int POSICION_DELANTERO = 4;

    int posicion;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public JugadorFutbol(String nombre, int dorsal, int posicion) {
        super(nombre, dorsal);
    }

    @Override
    public void jugar() {

        switch (this.posicion) {

            case POSICION_PORTERO:
                System.out.println("Futbolista: parando pelotas...");
                break;

            case POSICION_DEFENSA:
                System.out.println("Futbolista: cubriendo delanteros...");
                break;

            case POSICION_MEDIO:
                System.out.println("Futbolista: pasando pelotas...");
                break;

            case POSICION_DELANTERO:
                System.out.println("Futbolista: regateando defensas...");
                break;
        }
    }
}
