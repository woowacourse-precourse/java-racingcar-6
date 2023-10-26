package racingcar.view;

import racingcar.model.Car;
import racingcar.util.OutputRaceViewConstant;

import java.util.List;
import java.util.stream.Collectors;

public class OutputRaceView {
    public static void printRaceResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(OutputRaceViewConstant.WINNER_ANNOUNCEMENT
                + winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}