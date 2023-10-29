package racingcar.Domain;

import java.util.List;

public class Game {
    private final List<Car> carList;
    private final int totalTryCount;

    private int currentTryCount = 0;

    public Game(List<Car> carList, int totalTryCount) {
        this.carList = carList;
        this.totalTryCount = totalTryCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void incrementCurrentTryCount() {
        this.currentTryCount ++;
    }

    public Boolean finishTotalTryCountCheck() {
        return this.totalTryCount == this.currentTryCount;
    }
}
