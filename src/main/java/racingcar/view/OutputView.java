package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.printResult());
        }
        System.out.println();
    }
}