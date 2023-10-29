package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputHandler {
    public static void printRaceState(List<Car> cars) {
        for (Car car : cars) {
            printSingleCarState(car);
        }
        System.out.println();
    }

    private static void printSingleCarState(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new)));
    }
}
