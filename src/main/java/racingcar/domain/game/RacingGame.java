package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.generator.RandomNumberGenerator;

public class RacingGame {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void progress(List<Car> cars, int tryMaxCount) {
        int tryCount = 0;
        while (tryCount < tryMaxCount) {
            move(cars);
            tryCount++;
        }
    }

    private void move(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.createInRange(0, 9);
            if (isPossibleMove(randomNumber)) {
                car.move();
            }
        }
    }

    private boolean isPossibleMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<Car> getWinner(List<Car> cars) {
        Car maxPosition = findMaxPositionCar(cars);
        return  cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차가 없습니다."));

    }

}
