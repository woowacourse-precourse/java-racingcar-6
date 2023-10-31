package racingcar.view;

import java.util.StringJoiner;
import racingcar.constant.Message;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String RESULT_DELIMITER = "\n";
    private static final String COLON = " : ";
    private static final String DISTANCE_SYMBOL = "-";

    public static void printTryResult() {
        System.out.println(Message.TRY_RESULT.getMessage());
    }

    public static void printUpdatedResult(String updatedResult) {
        System.out.println(updatedResult);
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.print(Message.FINAL_WINNERS.getMessage());
        System.out.print(winners);
    }

    public static String updatedResult(Cars cars) {
        StringJoiner result = new StringJoiner(RESULT_DELIMITER);
        cars.getCars().forEach(car -> result.add(printCarResult(car)));
        return result.toString();
    }

    private static String printCarResult(Car car) {
        return car.getName() + COLON
                + DISTANCE_SYMBOL.repeat(car.getDistance());
    }
}