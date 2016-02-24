package ovh.matrix.test;

/**
 * Created by caligari on 23/02/2016.
 */
public class Pez extends Animal {

    int aletas;
    boolean medioSalado;

    public boolean isMedioSalado() {
        return medioSalado;
    }

    public void setMedioSalado(boolean medioSalado) {
        this.medioSalado = medioSalado;
    }

    public int getAletas() {
        return aletas;
    }

    public void setAletas(int aletas) {
        this.aletas = aletas;
    }

    public Pez(int tamanho, int peso, int aletas, boolean medioSalado) {

        super.setNombre("Pez");
        super.setTamanho(tamanho);
        super.setPeso(peso);

        this.aletas = aletas;
        this.medioSalado = medioSalado;
    }

    public void nadar() {
        System.out.println("Pez: nadando...");
    }
}
