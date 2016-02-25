package ovh.matrix.test12;

/**
 * Created by caligari on 2/24/16.
 */
public class JugadorTenis extends Jugador {

    private int ranking;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public JugadorTenis(String nombre, int ranking) {
        super(nombre, 0);
        this.ranking = ranking;
    }

    @Override
    public void jugar() {
        System.out.println("Tenista: peloteando...");
    }
}
