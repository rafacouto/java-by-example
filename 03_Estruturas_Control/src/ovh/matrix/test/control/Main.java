package ovh.matrix.test.control;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int levelCompleted = 5;
        int bonus = 100;
        int score = 800;

        if ((score > 1000) && (score < 5000)) {
            System.out.println("Puntos entre 1000 e 5000");
        } else {
            System.out.println("Puntos menor que 1000...");
        }
    }
}
