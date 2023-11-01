package racingcar.game;

import racingcar.car.Cars;
import racingcar.utils.view.Input;
import racingcar.utils.view.Messages;
import racingcar.utils.view.Output;

public class RacingGame {
    private final Input input = new Input();
    private final Output output = new Output();

    public void start() {
        Cars cars = setupCarsName();
        TryCount tryCount = setupTryCount();
        race(cars, tryCount);
    }

    private Cars setupCarsName() {
        output.printMessageLine(Messages.INPUT_CARS_NAME.getMessage());
        return input.readCarsName();
    }

    private TryCount setupTryCount() {
        output.printMessageLine(Messages.INPUT_TRY_COUNT.getMessage());
        return input.readTryCount();
    }

    private void race(Cars cars, TryCount tryCount) {
        output.printMessageLine(Messages.RESULT.getMessage());
        while (tryCount.isMoreTry()) {
            cars.tried();
            tryCount.tried();
        }
    }
}
