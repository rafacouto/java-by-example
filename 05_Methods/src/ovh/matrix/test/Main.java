package ovh.matrix.test;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;

        int score = 800;
        int bonus = 100;
        int levelCompleted = 5;

        score = getFinalScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Final score: " + score);
    }


    public static int getFinalScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted + bonus);
            finalScore += 200;
            return finalScore;
        }

        return score;
    }
}
