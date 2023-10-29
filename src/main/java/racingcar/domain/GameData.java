package racingcar.domain;

public class GameData {

    private Cars cars;
    private final TryCount tryCount;

    public GameData(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

}
