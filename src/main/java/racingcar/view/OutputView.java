package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printRaceStatus(List<Car> cars) {
        StringBuilder status = new StringBuilder();
        for (Car car : cars) {
            status.append(car.name).append(" : ");
            for (int i = 0; i < car.location; i++) {
                status.append('-');
            }
            status.append('\n');
        }
        System.out.println(status);
    }
}
