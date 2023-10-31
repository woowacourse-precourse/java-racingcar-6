package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {
    private static final String COUNT_MARK = "-";

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + COUNT_MARK.repeat(car.getPosition()));
        }
        System.out.println();
    }
}
