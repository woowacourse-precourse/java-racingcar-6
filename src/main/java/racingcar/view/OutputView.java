package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), car.getStringLocation());
        }
        System.out.println();
    }

}
