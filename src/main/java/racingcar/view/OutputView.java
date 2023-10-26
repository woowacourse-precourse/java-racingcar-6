package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printResult(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }
}
