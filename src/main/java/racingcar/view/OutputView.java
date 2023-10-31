package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String COLON = " : ";
    private static final String ADVANCED_ICON = "-";
    private static final String NEW_LINE = "\n";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printRequestNumberOfAttemptsMessage() {
        System.out.println(GAME_NUMBER_OF_ATTEMPTS);
    }

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printGameResult(List<Car> cars, int numberOfAttempts) {
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            printNumberOfAttempts(attempt);
        }
    }

    public static void printNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts < numberOfAttempts - 1) {
            System.out.println();
        }
    }

    public static void printCurrentPositions(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getName()).append(COLON).append(generateAdvancedIcon(car.getPosition())).append(NEW_LINE);
        }
        System.out.println(result);
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private static String generateAdvancedIcon(int position) {
        StringBuilder icon = new StringBuilder();
        for (int index = 0; index < position; index++) {
            icon.append(ADVANCED_ICON);
        }
        return icon.toString();
    }
}