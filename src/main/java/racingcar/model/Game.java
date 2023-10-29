package racingcar.model;

import java.util.List;

public class Game {
    private int order = 0;
    private final List<Car> cars;

    private final int numGames;

    public Game(int numGames, List<Car> cars) {
        this.cars = cars;
        this.numGames = numGames;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increaseGameOrder() {
        this.order++;
    }

    public boolean checkGamesExhausted() {
        return this.order >= this.numGames;
    }
}
