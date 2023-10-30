package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class CarView {
    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }
}
