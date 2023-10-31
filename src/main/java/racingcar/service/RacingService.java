package racingcar.service;

import static racingcar.domain.enums.Constants.MIN_RACING_COUNT;

import racingcar.domain.Cars;

public class RacingService {

    private Cars cars;
    private int racingCount;

    public RacingService(Cars cars, int racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public void playRacing() {
        cars.moveCars();
        racingCount--;
    }

    public boolean isPlayRacing() {
        return racingCount >= MIN_RACING_COUNT;
    }

    public Cars getCars() {
        return cars;
    }
}