package racingcar;

import java.util.List;

public class Round {
    List<Car> cars;

    Round(List<Car> cars) {
        this.cars = cars;
    }

    void playRound() {
        for (Car car : cars) {
            car.move();
            printMovementResult(car);
        }
        System.out.println();
    }

    void printMovementResult(Car car) {
        String result = car.getName() + " : " + "-".repeat(Math.max(0, car.getMoveDistance()));
        System.out.println(result);
    }
}
