package racingcar;

import java.util.List;

public class Game {
    private List<Car> cars;
    private int round;

    public Game(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }
    public void play() {

    }

    public String getWinner() {
        return null;
    }

    private int getMaximumPosition() {
        return 0;
    }

    private String findWinner() {
        return null;
    }
}
