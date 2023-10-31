package racingcar.model;

import racingcar.view.RoundView;

import java.util.List;

public class Round {

    private final List<Car> CARS;

    private Round(List<Car> cars) {
        this.CARS = cars;
    }

    public static Round carsOf(List<Car> cars) {
        return new Round(cars);
    }

    public void playRound(int numAttempts) {
        for (int round = 1; round <= numAttempts; round++) {
            moveAllCarsOneRound();
            RoundView.printRoundResults(CARS);
        }
    }

    private void moveAllCarsOneRound() {
        for (Car car : CARS) {
            car.move();
        }
    }
}
