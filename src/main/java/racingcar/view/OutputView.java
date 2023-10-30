package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.PrintMessage;

import java.util.List;

public class OutputView {
    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printSticks(car.getMovement());
        }
        System.out.println();
    }

    public static void printSticks(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
