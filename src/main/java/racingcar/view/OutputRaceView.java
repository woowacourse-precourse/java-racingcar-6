package racingcar.view;

import racingcar.model.Car;
import racingcar.util.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class OutputRaceView {
    public static void printRaceResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(Constants.WINNER_ANNOUNCEMENT + winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}