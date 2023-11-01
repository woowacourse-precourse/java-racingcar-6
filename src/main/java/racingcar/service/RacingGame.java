package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.VisibleForTesting;
import racingcar.model.Car;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.util.OutputUtils.*;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int FORWARD_MOVEMENT_THRESHOLD = 4;

    public RacingGame(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void play() {
        printTitleResult();

        IntStream.range(0, tryCount)
                .forEach(i -> runCurrentTry());

        printFinalWinners(findWinnerNames(getMaxCarMovement()));
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    @VisibleForTesting
    protected void moveCarByThreshold(int currentNumber, Car car) {
        if (currentNumber >= FORWARD_MOVEMENT_THRESHOLD) {
            car.updateMovement();
        }
    }

    private void runCurrentTry() {
        cars.forEach(car -> moveCarByThreshold(generateRandomNumber(), car));
        printResultPerTry(cars);
    }

    @VisibleForTesting
    protected List<String> findWinnerNames(int winnerMovement) {
        return cars.stream()
                .filter(car -> car.getMovement() == winnerMovement)
                .map(Car::getName).toList();
    }

    @VisibleForTesting
    protected int getMaxCarMovement() {
        int max = -1;
        for (Car car : cars) {
            max = Math.max(max, car.getMovement());
        }
        return max;
    }
}
