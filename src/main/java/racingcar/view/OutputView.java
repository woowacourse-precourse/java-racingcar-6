package racingcar.view;

import java.util.List;

public class OutputView {
    public static final String GAME_RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";
    public static final String DASH = "-";

    public static void printCarNameFormat(String carName) {
        System.out.print(carName + " : ");
    }
    public static void printOneCarResult(String carName, int distance) {
        printCarNameFormat(carName);
        printDash(distance);
        System.out.println();
    }

    private static void printDash(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(DASH);
        }
    }

    public static void printGameResult() {
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printWinner() {
        System.out.print(WINNER_ANNOUNCEMENT_MESSAGE);
    }

    public static void printWinnerName(List<String> winnerNameList) {
        System.out.print(String.join(", ", winnerNameList));
    }
}
