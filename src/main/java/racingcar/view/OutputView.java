package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String RESULT_MESSAGE = "최종 우승자 : ";
    private static final String JOINING_COMMA = ", ";
    public static void printNameInputMessage() {
        printlnMessage(NAME_INPUT_MESSAGE);
    }

    public static void printRoundInputMessage() {
        printlnMessage(ROUND_INPUT_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println();
        printlnMessage(EXECUTION_RESULT);
    }

    public static void printCarNameAndPosition(Car car) {
        String dashes = createDashes(car.getPosition());
        String result = car.getName() + COLON + dashes;
        printlnMessage(result);
    }

    public static String createDashes(int position) {
        return DASH.repeat(position);
    }

    public static void printWinners(List<Car> cars) {
        String joinCommaWinners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(JOINING_COMMA));
        String result = RESULT_MESSAGE + joinCommaWinners;
        printlnMessage(result);
    }

    private static void printlnMessage(String message) {
        System.out.print(message);
    }
}
