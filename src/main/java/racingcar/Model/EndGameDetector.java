package racingcar.Model;

public class EndGameDetector {
    private static boolean won = false;

    public static void setWon(boolean won) {
        EndGameDetector.won = won;
    }

    public static boolean isWon() {
        return won;
    }
}
