package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Output;

import java.util.List;

public class CarRacingGame {

    public void start(int gameCount, Cars cars) {
        Output output = new Output();
        for (int i = 0; i < gameCount; i++) {
            List<Car> moveResult = cars.moveAllCar();
            output.printMoveResult(moveResult);
        }
    }
}