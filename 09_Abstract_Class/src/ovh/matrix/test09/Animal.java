package ovh.matrix.test09;

/**
 * Created by caligari on 2/24/16.
 */
public abstract class Animal {

    String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void comer() {
        System.out.println("Animal: comiendo...");
    }
}
