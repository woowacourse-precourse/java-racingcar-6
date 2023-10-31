package racingcar.view;

public class OutputView {

    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String GAME_WINNER_MESSAGE = "최종 우승자 : ";

    public static void printResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printWinnerMessage() {
        System.out.print(GAME_WINNER_MESSAGE);
    }
}
