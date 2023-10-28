package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class OutputView {

    public static void displayCarMovements(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.name() + " : ");
            printHyphens(car.position());
        }
    }

    public static void displayWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        String winnerNames = winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames);
    }

    private static void printHyphens(int count) {
        IntStream.range(0, count).mapToObj(i -> "-").forEach(System.out::print);
    }
}

