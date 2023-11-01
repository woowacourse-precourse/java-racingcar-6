package racingcar.model;

import java.util.List;

public class RacingGame {
    private static final int MOVE_THRESHOLD = 4;
    private final Cars cars;
    private final int raceCount;

    private RacingGame(Cars cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public static RacingGame init(Cars cars, int raceCount) {
        return new RacingGame(cars, raceCount);
    }

    public void playGame(RandomSingleNumber number) {
        for (Car car : cars.getCarList()) {
            if (number.isAtLeast(MOVE_THRESHOLD)) {
                car.move();
            }
        }
    }

    public GameResult getGameResult() {
        return GameResult.of(cars.getMaxPositionCars());
    }

    public List<Car> getCarList() {
        return cars.getCarList();
    }

    public int getRaceCount() {
        return raceCount;
    }
}
