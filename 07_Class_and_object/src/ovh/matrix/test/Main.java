package ovh.matrix.test;

public class Main {

    public static void main(String[] args) {

        Coche seat = new Coche();

        seat.setColor("gris");
        seat.setMarca("Seat");
        seat.setModelo("Ibiza");
        seat.setPuertas(3);
        seat.setRuedas(4);

        Pez pez1 = new Pez(10, 1, 3, true);
        pez1.comunicar();
        pez1.nadar();
    }
}
