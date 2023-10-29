package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.GameCount;
import racingcar.domain.Output;

public class CarRacingGame {

    private final Output output;

    public CarRacingGame(Output output) {
        this.output = output;
    }

    public void start(GameCount gameCount, Cars cars) {
        while (gameCount.hasRemainCount()) {
            cars.moveAllCar();
            output.printMoveResult(cars);
        }
    }
}
