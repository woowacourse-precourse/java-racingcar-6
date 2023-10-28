package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class GameResult {
    public static final String DASH_CHARACTER = "-";
    public static final String CAR_NAME_DELIMITER = ",";

    public static void result(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : ", car.getName());
            printDashes(car.getMovingCount());
        }
    }

    public static void finalResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(CAR_NAME_DELIMITER, winners));
    }

    private static void printDashes(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(DASH_CHARACTER);
        }
        System.out.println();
    }
}
