package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            printRace(car);
        }
        System.out.println();
    }

    public static void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
