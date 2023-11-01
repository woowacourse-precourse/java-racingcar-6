package racingcar.view.output;

public class GameOutputView {
    public static void printRaceStart() {
        System.out.println(GameOutputMessage.RACE_START.getMessage());
    }

    public static void printGameResult(String result) {
        System.out.println(GameOutputMessage.WINNER_RESULT.getMessage() + result);
    }

    public static void printGameProceeding(String carName, int distance) {
        System.out.printf(
                GameOutputMessage.GAME_PROCEEDING.getMessage(),
                carName,
                GameOutputMessage.DISTANCE_INDICATOR.getMessage().repeat(distance)
        );
    }

    public static void printGapLine() {
        System.out.println();
    }
}
