package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;


public class OutputView {
    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionString());
    }
    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

}

