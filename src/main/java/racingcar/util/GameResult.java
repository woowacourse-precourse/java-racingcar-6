package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class GameResult {
    private static final String DASH_CHARACTER = "-";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String FINAL_WINNERS_LABEL = "최종 우승자 : ";

    public static void result(List<Car> cars) {
        for (Car car : cars) {
            printCarDetails(car);
        }
    }

    private static void printCarDetails(Car car) {
        System.out.printf("%s : %s\n", car.getName(), DASH_CHARACTER.repeat(car.getMovingCount()));
    }

    public static void finalResult(List<String> winners) {
        System.out.println(FINAL_WINNERS_LABEL + String.join(CAR_NAME_DELIMITER, winners));
    }
}
