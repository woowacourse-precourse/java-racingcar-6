package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String DASH = "-";
    private static final String COLON = " : ";
    public static void printNameInputMessage() {
        printlnMessage(NAME_INPUT_MESSAGE);
    }

    public static void printRoundInputMessage() {
        printlnMessage(ROUND_INPUT_MESSAGE);
    }

    public static void printCarNameAndPosition(Car car) {
        String dashes = createDashes(car.getPosition());
        String result = car.getName() + COLON + dashes;
        printlnMessage(result);
    }

    public static String createDashes(int position) {
        return DASH.repeat(position);
    }

    private static void printlnMessage(String message) {
        System.out.print(message);
    }
}
