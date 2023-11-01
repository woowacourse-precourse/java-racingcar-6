package racingcar.domain;

import java.util.List;

public class Race {

    private static final int MOVE_PIVOT_NUMBER = 4;
    private static final int END_GAME_ROUND = 0;
    private final Cars cars;
    private int gameCount;

    public Race(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public boolean hasNextRound() {
        return this.gameCount > END_GAME_ROUND;
    }

    public void playOneRound() {
        this.cars.driveOneRoundAllCar(MOVE_PIVOT_NUMBER);
        this.gameCount--;
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public List<Car> getWinners() {
        return this.cars.getWinners();
    }
}
