package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String COLON = " : ";
    private static final String ADVANCED_ICON = "-";
    private static final String NEW_LINE = "\n";

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

    private static String generateAdvancedIcon(int position) {
        StringBuilder icon = new StringBuilder();
        for (int index = 0; index < position; index++) {
            icon.append(ADVANCED_ICON);
        }
        return icon.toString();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자: " + winnerNames);
    }
}