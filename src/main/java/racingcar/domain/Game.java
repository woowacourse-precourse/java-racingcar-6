package racingcar.domain;

import java.util.List;

public class Game {
    private final int playCountEnd;
    private final List<Car> cars;
    private int playCount = 0;
    public Game(List<Car> cars, int playCountEnd) {
        this.cars = cars;
        this.playCountEnd = playCountEnd;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void incresePlayCount(){
        this.playCount++;
    }

    public boolean checkEndPlayCount(){
        return this.playCount == this.playCountEnd;
    }
}
