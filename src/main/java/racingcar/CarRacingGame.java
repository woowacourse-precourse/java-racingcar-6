package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Output;

import java.util.List;

public class CarRacingGame {

    Output output;

    public CarRacingGame(Output output) {
        this.output = output;
    }

    public void start(int gameCount, Cars cars) {
        for (int i = 0; i < gameCount; i++) {
            List<Car> moveResult = cars.moveAllCar();
            output.printMoveResult(moveResult);
        }
    }
}