package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String RESULT_MESSAGE = "최종 우승자 : ";
    private static final String JOINING_COMMA = ", ";

    public static void printNameInputMessage() {
        printMessage(NAME_INPUT_MESSAGE);
    }

    public static void printRoundInputMessage() {
        printMessage(ROUND_INPUT_MESSAGE);
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printExecutionResultMessage() {
        printBlankLine();
        printMessage(EXECUTION_RESULT_MESSAGE);
    }

    public static void printCarNameAndPosition(Car car) {
        String dashes = DASH.repeat(car.getPosition());
        String result = car.getName() + COLON + dashes;
        printMessage(result);
    }

    public static void printWinners(List<String> carNames) {
        String joinCommaWinners = String.join(JOINING_COMMA, carNames);
        String result = RESULT_MESSAGE + joinCommaWinners;
        printMessage(result);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
