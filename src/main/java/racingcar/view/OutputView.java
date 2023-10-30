package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }

        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
