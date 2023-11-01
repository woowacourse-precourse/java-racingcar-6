package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private long n;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }
    public void setN(long n) {
        this.n = n;
    }
    public long getN() {
        return n;
    }
}
