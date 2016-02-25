package ovh.matrix.test12;

import java.util.ArrayList;

/**
 * Created by caligari on 2/24/16.
 */
public class Club {

    public static final int DEPORTE_TENIS = 1;
    public static final int DEPORTE_FUTBOL = 2;

    private String nombre;

    ArrayList<Jugador> jugadores = new ArrayList<>();
    ArrayList<Socio> socios = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public Club(String nombre) {
        this.nombre = nombre;
    }

    public void listarPersonas() {

        for (Jugador j : this.jugadores) {
            System.out.println(j.getNombre() + " (jugador)");
        }

        for (Socio s : this.socios) {
            System.out.println(s.getNombre() + " (socio)");
        }
    }

    public void listarJugadores () {

        for (Jugador j : this.jugadores) {
            System.out.println("Jugador: " + j.getNombre() + " [dorsal " + j.getDorsal() + "]");
        }
    }

    public void listarSocios() {

        for (Socio s : this.socios) {
            System.out.println("Socio: " + s.getNombre() + " [número " + s.getNumero() + "]");
        }
    }

    public void addSocio(String nombre) {

        int numero = socios.size() + 1;

        socios.add(new Socio(nombre, numero));
    }

    public void addJugador(String nombre, int deporte) {

        int dorsal = jugadores.size();

        switch (deporte) {

            case DEPORTE_TENIS:
                jugadores.add(new JugadorTenis(nombre, dorsal));
                break;

            case DEPORTE_FUTBOL:
                jugadores.add(new JugadorTenis(nombre, dorsal));
                break;
        }
    }

    public void addJugador(JugadorTenis jugadorTenis) {
    }
}
