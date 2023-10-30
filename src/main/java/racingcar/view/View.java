package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class View {
    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            printScoreOfCars(car);
        }
        System.out.println();
    }

    private static void printScoreOfCars(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
