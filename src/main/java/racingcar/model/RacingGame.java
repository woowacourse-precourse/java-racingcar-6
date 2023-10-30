package racingcar.model;

import static racingcar.common.Constant.RAND_NUM_MAX_RANGE;
import static racingcar.common.Constant.RAND_NUM_MIN_RANGE;

import racingcar.util.NumberGenerator;

public class RacingGame {
    private static final int MOVE_THRESHOLD = 4;
    private final Cars cars;
    private final int raceCount;

    private RacingGame(Cars cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public static RacingGame init(Cars carList, int raceCount) {
        return new RacingGame(carList, raceCount);
    }

    public void playRaceGame() {
        for (Car car : cars.getCarList()) {
            int randomNumber = NumberGenerator.getRandomDigit(RAND_NUM_MIN_RANGE, RAND_NUM_MAX_RANGE);

            if (isOverThreshold(randomNumber)) {
                car.move();
            }
        }
    }

    private boolean isOverThreshold(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
