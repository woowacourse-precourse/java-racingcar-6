package racingcar.game;

import racingcar.game.Car;
import racingcar.io.IOHandler;

import java.util.Comparator;
import java.util.List;

public class RacingGame {

    private final IOHandler ioHandler = new IOHandler();

    public void start() {
        List<String> carNames = ioHandler.inputCarNames();
        int attemptCount = ioHandler.inputAttemptCount();

        List<Car> cars = Car.createCars(carNames);
        attemptForwardByCount(cars, attemptCount);

        List<String> winners = getWinners(cars);
        ioHandler.printWinners(winners);
    }

    private void attemptForwardByCount(List<Car> cars, int attemptCount) {
        System.out.println("실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(Car::attemptForward);
            ioHandler.printAttemptResult(cars);
        }
    }

    private List<String> getWinners(List<Car> cars) {
        int maxCount = cars.stream()
                .max(Comparator.comparingInt(Car::getForwardCount))
                .map(Car::getForwardCount)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getForwardCount() == maxCount)
                .map(Car::getName)
                .toList();
    }

}
