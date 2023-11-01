package racingcar.view;

import racingcar.domain.Winners;
import racingcar.message.Messages;
import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String DISTANCE_MARK = "-";
    private static final String COLON = " : ";
    private static final String DELIMITER = ", ";

    public static void printExecutionResult() {
        System.out.println();
        System.out.println(Messages.EXECUTION_RESULT);
    }

    public static void printWinners(Winners winners) {
        System.out.println(Messages.PRINT_WINNERS_MESSAGE + String.join(DELIMITER, winners.getWinnerNames()));
    }

    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printOneCarPosition(car));
        }
        System.out.println();
    }

    private static String printOneCarPosition(Car car) {
        return car.getName() + COLON + printDistanceMark(car.getPosition());
    }

    private static String printDistanceMark(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DISTANCE_MARK.repeat(Math.max(0, count)));
        return stringBuilder.toString();
    }
}
