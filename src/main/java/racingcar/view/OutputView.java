package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.race.Car;

public class OutputView {
    private final List<Car> cars;

    public OutputView(List<Car> cars) {
        this.cars = cars;
    }

    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
