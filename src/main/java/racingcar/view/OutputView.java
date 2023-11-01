package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printResult(List<Car> carList) {

        for (Car car : carList) {
            printCarStatus(car);
        }

        System.out.println();
    }

    public static void printCarStatus(Car car) {

        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

}
