package racingcar.Service;

import java.util.List;
import racingcar.Model.Car;
import racingcar.IO.Input;
import racingcar.IO.Output;

public class RacingGame {

    private List<Car> cars;
    private int attempts;

    public void gameStart() {
        cars = Input.getCars();
        attempts = Input.getAttempts();

        System.out.println();
    }

    public void gamePlay() {
        System.out.println("실행결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.moveCar();
            }
            System.out.println();
        }
    }

    public void gameEnd() {
        int longestDistance = getLongestDistance();

        Output.printWinners(cars, longestDistance);

    }

    public int getLongestDistance() {
        return cars.stream()
                .mapToInt(Car::getLength)
                .max()
                .orElse(0);
    }
}
