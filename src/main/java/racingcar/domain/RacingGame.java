package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private long n;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isNotZero() {
        return n > 0;
    }
    public List<Car> getCars() {
        return cars;
    }

    public void setN(long n) {
        this.n = n;
    }
    public long getN() {
        return n;
    }

    public void decreaseN() {
        n--;
    }
}
