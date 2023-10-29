package racingcar.domain;

import racingcar.domain.car.Cars;
import racingcar.domain.numberpicker.RandomNumberPicker;

public class RacingGame {

    private final Cars cars;
    private long movingCount;
    private GameStatus gameStatus;

    private RacingGame(Cars cars, long movingCount, GameStatus gameStatus) {
        this.cars = cars;
        this.movingCount = movingCount;
        this.gameStatus = gameStatus;
    }

    public static RacingGame newGame(Cars cars, long movingCount) {
        return new RacingGame(cars, movingCount, GameStatus.IN_PROGRESS);
    }

    public void moveOnce(RandomNumberPicker randomNumberPicker) {
        this.cars.moveOnce(randomNumberPicker);
        decreaseMovingCountByOne();
    }

    private void decreaseMovingCountByOne() {
        movingCount--;

        if (movingCount == 0) {
            this.gameStatus = GameStatus.END;
        }
    }

    public boolean isEnd() {
        return this.gameStatus.isEnd();
    }

}
