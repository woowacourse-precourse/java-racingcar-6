package racingcar.domain;

import java.util.List;

public class RacingMachine {
    private List<Car> cars;
    private int playCount;

    public RacingMachine(List<Car> cars, int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }
}
