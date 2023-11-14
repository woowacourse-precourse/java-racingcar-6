package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String RACE_START = "실행 결과";
    private static final String NAME_FORWARD_COUNT_DELIMITER = " : ";
    private static final String FORWARD_COUNT = "-";
    private static final String WINNERS = "최종 우승자 : ";
    private static final String WINNERS_DELIMITER = ", ";

    public static void printRaceStart() {
        System.out.println();
        System.out.println(RACE_START);
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(car -> {
            String name = car.getName();
            int forwardCount = car.getForwardCount();
            System.out.println(name + NAME_FORWARD_COUNT_DELIMITER + FORWARD_COUNT.repeat(forwardCount));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNERS + String.join(WINNERS_DELIMITER, winners));
    }
}
