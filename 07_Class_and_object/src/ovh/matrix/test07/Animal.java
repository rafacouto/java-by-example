package ovh.matrix.test07;

/**
 * Created by caligari on 23/02/2016.
 */
public class Animal {

    private String nombre;
    private int tamanho;
    private int peso;

    protected Animal() {}

    public Animal(String nombre, int tamanho, int peso) {
        this.nombre = nombre;
        this.tamanho = tamanho;
        this.peso = peso;
    }

    /* getters and setters */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }



    /* interface */

    public void comunicar() {
        System.out.println("Animal: comunicando...");
    }

    public void comer() {
        System.out.println("Animal: comiendo...");
    }

}
