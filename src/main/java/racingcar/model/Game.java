package racingcar.model;

import java.util.List;

public class Game {
    private List<Car> carList;
    private int roundNumber;

    public Game(List<Car> carList, int roundNumber) {
        this.carList = carList;
        this.roundNumber = roundNumber;
    }

    public List<Car> getcarList() {
        return carList;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
