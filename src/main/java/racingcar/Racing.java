package racingcar;

import java.util.List;

public class Racing {
    private int tryNumber;
    private List<Car> car;

    public Racing(int tryNumber, List<Car> car) {
        this.tryNumber = tryNumber;
        this.car = car;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}