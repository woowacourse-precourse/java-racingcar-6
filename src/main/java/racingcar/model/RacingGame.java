package racingcar.model;

public class RacingGame {
    private final Cars cars;
    private final int raceCount;

    private RacingGame(Cars cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public static RacingGame init(Cars carList, int raceCount) {
        return new RacingGame(carList, raceCount);
    }
}
