package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RaceView {
    private RaceView() {
    }

    public static void displayRoundResults(List<Car> cars) {
        for (Car car : cars) {
            car.displayProgress();
        }
        System.out.println();
    }

    public static void displayWinner(List<Car> cars) {
        String winner = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println("최종 우승자 : " + winner);
    }
}
