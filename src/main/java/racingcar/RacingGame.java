package racingcar;

import java.util.List;

public class RacingGame {

    private final IOHandler ioHandler = new IOHandler();

    public void start() {
        List<String> carNames = ioHandler.inputCarNames();
        int attemptCount = ioHandler.inputAttemptCount();

        List<Car> cars = Car.createCars(carNames);

        // TODO: List<String> winners = getWinners(cars, attemptCount);
        // TODO: ioHandler.printWinners(winners);
    }

}
