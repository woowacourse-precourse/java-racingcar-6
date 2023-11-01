package racingcar.model;

import java.util.List;

public class Game {

    private final int race;
    private final List<Car> cars;
    private int raceNum = 0;

    public Game(List<Car> cars, int race) {
        this.cars = cars;
        this.race = race;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increseRaceNum() {
        this.raceNum += 1;
    }

    public Boolean checkResult() {
        return this.raceNum == this.race;
    }
}
