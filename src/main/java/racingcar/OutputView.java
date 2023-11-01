package racingcar;

import java.util.List;

public class OutputView {
    private static final String EXECUTION_RESULT_TEXT = "실행 결과";
    private static final String MOVE = "-";
    private static final String FINAL_WINNERS = "최종 우승자";
    private static final String DELIMITER = " : ";
    private static final String WINNERS_DELIMITER = ", ";

    public static void printExecutionResultText() {
        System.out.println(EXECUTION_RESULT_TEXT);
    }

    public static void printRoundResult(Car car) {
        System.out.println(car.getName() + DELIMITER + MOVE.repeat(car.getPosition()));
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        List<String> winners = getWinnersName(cars);
        System.out.println(FINAL_WINNERS + DELIMITER + String.join(WINNERS_DELIMITER, winners));
    }

    private static List<String> getWinnersName(List<Car> cars) {
        int maxPosition = getWinnersPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private static int getWinnersPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }
}
