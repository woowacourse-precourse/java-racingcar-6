package racingcar.view;

import java.util.List;
import racingcar.util.StringUtils;

public class OutputView {

    private static final String PLAY_RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String DISTANCE_MARK = "-";
    private static final String FINAL_WINNER = "최종 우승자";

    public OutputView() {
    }

    public static void printResultMessage() {
        printNewLine();
        System.out.println(PLAY_RESULT_MESSAGE);
    }

    public static void printStatus(String name, int position) {
        System.out.print(name + COLON);
        for (int distance = 0; distance < position; distance++) {
            System.out.print(DISTANCE_MARK);
        }
        printNewLine();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(FINAL_WINNER + COLON);
        StringUtils stringUtils = new StringUtils();
        System.out.println(stringUtils.join(winners));
    }
}
