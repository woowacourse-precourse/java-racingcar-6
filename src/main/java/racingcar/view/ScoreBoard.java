package racingcar.view;

public class ScoreBoard {

    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    private ScoreBoard() {
    }

    public static void displayRacingProgress(String racingProgress) {
        System.out.println(racingProgress);
        System.out.println();
    }

    public static void displayWinnerNames(String winnerNames) {
        System.out.println(WINNER_MESSAGE_PREFIX + winnerNames);
    }
}
