package racingcar.view;

import java.util.List;

public class ScoreBoard {

    private static final String GAME_PROGRESS_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    private ScoreBoard() {
    }

    public static void displayGameProgressMessage() {
        System.out.println();
        System.out.println(GAME_PROGRESS_MESSAGE);
    }

    public static void displayCurrentRacingCarsPosition(String currentRacingPosition) {
        System.out.println(currentRacingPosition);
        System.out.println();
    }

    public static void displayWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE_PREFIX + joinWinners(winners));
    }

    private static String joinWinners(List<String> winners) {
        return String.join(", ", winners);
    }
}
