package racingcar.domain;

import java.util.List;

public class Game {

    private static final int DEFAULT_TOTAL_ATTEMPTS = 0;
    public static final int DISTANCE_TO_MOVE = 1;

    private final int totalAttempts;
    private final RacingCars racingCars;
    private int attempts;

    public Game(RacingCars racingCars, int totalAttempts) {
        this.racingCars = racingCars;
        this.totalAttempts = totalAttempts;
        this.attempts = DEFAULT_TOTAL_ATTEMPTS;
    }

    public void increaseAttempts() {
        this.attempts += 1;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCars.getRacingCars();
    }

    public boolean isGameEnd() {
        return attempts == totalAttempts;
    }

}
