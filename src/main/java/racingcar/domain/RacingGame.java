package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int tryCount;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(List<RacingCar> racingCars, int tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            moveRacingCars();
        }
    }

    private void moveRacingCars() {
        for (RacingCar car : racingCars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(randomNumber);
        }
    }
}
