package racingcar.view;

import java.util.List;
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
        List<String> carsName = cars.stream().map(Car::getName).toList();
        String winner = String.join(",", carsName);
        System.out.print("최종 우승자 : " + winner + "\n");
    }
}
