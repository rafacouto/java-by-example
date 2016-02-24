package ovh.matrix.test07;

/**
 * Created by caligari on 23/02/2016.
 */
public class Perro extends Animal {

    int patas;
    int ojos;

    public Perro(int tamanho, int peso) {

        super.setNombre("Perro");
        super.setTamanho(tamanho);
        super.setPeso(20);

        this.patas = 4;
        this.ojos = 2;
    }

    private void masticar() {
        System.out.println("Perro: masticando");
    }

    @Override
    public void comer() {
        this.masticar();
    }
}
