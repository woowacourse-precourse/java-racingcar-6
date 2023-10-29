package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputHandler {
    public static void printRaceState(List<Car> cars) {
        for (Car car : cars) {
            printSingleCarState(car);
        }
        System.out.println();
    }

    private static void printSingleCarState(Car car) {
        System.out.println(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.println("-");
        }
        System.out.println();
    }
    public static void printWinners(List<Car> winners) {
        System.out.println("최종 우승자: ");
        System.out.println(String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new)));
    }
}
