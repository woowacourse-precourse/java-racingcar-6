package racingcar;

import java.util.Comparator;
import java.util.List;

public class RacingGame {

    private final IOHandler ioHandler = new IOHandler();

    public void start() {
        List<String> carNames = ioHandler.inputCarNames();
        int attemptCount = ioHandler.inputAttemptCount();

        List<Car> cars = Car.createCars(carNames);
        List<String> winners = getWinners(cars, attemptCount);

        // TODO: ioHandler.printWinners(winners);
    }

    private List<String> getWinners(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            // TODO: attemptForward(cars);
        }

        int maxForwardCount = cars.stream()
                .max(Comparator.comparingInt(Car::getForwardCount))
                .map(Car::getForwardCount)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .map(Car::getName)
                .toList();
    }


}
