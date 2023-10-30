package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String RESULT_COMMAND = "\n실행 결과";
    private static final String COLON_SPACE = " : ";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String COMMA = ", ";
    private static final String HYPHEN = "-";

    public static void printResultCommand() {
        System.out.println(RESULT_COMMAND);
    }

    public static void printRoundResult(String[] carNames, int[] distance) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + COLON_SPACE + generateHyphen(distance[i]));
        }
        System.out.println();
    }

    private static String generateHyphen(int count) {
        return HYPHEN.repeat(count);
    }

    public static void printWinner(List<String> winners) {
        System.out.print(FINAL_WINNER + String.join(COMMA, winners));
    }
}
