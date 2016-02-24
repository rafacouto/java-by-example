package ovh.matrix.test09;

/**
 * Created by caligari on 2/24/16.
 */
public class Pinguino extends Pajaro{

    public Pinguino(String nombre) {

        super(nombre);
    }

    @Override
    public void volar() {

        System.out.println("Pinguino: volando...");
    }
}
