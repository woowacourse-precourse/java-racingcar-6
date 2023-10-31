package racingcar.view;

import java.util.List;

/**
 * 출력을 위한 클래스다.
 *
 * @author haiseong
 */
public class OutputView {
    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTE_RESULT_MESSAGE = "실행결과";
    private static final String WINNERS_MESSAGE = "최종 우승자";
    private static final String COLON_DELIMITER = " : ";
    private static final String COMMA_DELIMITER = ", ";
    private static final String DISTANCE_MARKER = "-";

    public static void println() {
        System.out.println();
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void printCarInputMessage() {
        println(CAR_INPUT_MESSAGE);
    }

    public static void printRoundCountInputMessage() {
        println(ROUND_COUNT_INPUT_MESSAGE);
    }

    public static void printExecuteResultMessage() {
        println();
        println(EXECUTE_RESULT_MESSAGE);
    }

    public static void printDistanceMarker(String name, int distance) {
        println(name + COLON_DELIMITER + DISTANCE_MARKER.repeat(distance));
    }

    public static void printWinnersMessage(List<String> winners) {
        println(WINNERS_MESSAGE + COLON_DELIMITER + String.join(COMMA_DELIMITER, winners));
    }
}
