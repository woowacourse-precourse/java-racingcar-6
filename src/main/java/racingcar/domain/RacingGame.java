package racingcar.domain;

import java.util.List;

public class RacingGame {
    private List<Car> carList;
    private int raceCount;

    public RacingGame(List<Car> carList, int raceCount) {
        this.carList = carList;
        this.raceCount = raceCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
