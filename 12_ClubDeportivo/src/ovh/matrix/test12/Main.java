package ovh.matrix.test12;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Club conxo = new Club("Deportivo de Conxo");

        conxo.addSocio("Mariano Jubilado");

        conxo.addJugador(new JugadorTenis("Rafa Navidad", 4));

        conxo.listarPersonas();
    }
}
