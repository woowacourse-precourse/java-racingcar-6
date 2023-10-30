package racingcar.model;

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
            RandomSingleNumber number = RandomSingleNumber.create();

            if (number.isAtLeast(MOVE_THRESHOLD)) {
                car.move();
            }
        }
    }

    public Cars getCars() {
        return cars;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
