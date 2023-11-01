package racingcar.games.racing.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.games.racing.domain.Car;
import racingcar.games.racing.util.RacingProcessor;

public class RacingService {
    private static List<Car> cars;
    private final RacingProcessor racingProcessor;

    public RacingService(RacingProcessor racingProcessor) {
        this.racingProcessor = racingProcessor;
    }

    public void move() {
        racingProcessor.moveProcess(cars);
    }

    public void registerCars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<String> makePlayResult() {
        return cars.stream()
                .map(Car::getMoveResult)
                .collect(Collectors.toList());
    }

    public List<String> makeWinnerList() {
        int maxPosition = getMaxPositionLength();
        return cars.stream()
                .filter(car -> car.getPositionLength() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPositionLength() {
        int maxLength = 0;
        for (Car car : cars) {
            maxLength = Math.max(maxLength, car.getPositionLength());
        }
        return maxLength;
    }
}
