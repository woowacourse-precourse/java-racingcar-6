package racingcar.controller;

import java.util.List;
import racingcar.model.Car;

public class Game {

    private final Race race;

    public Game(String[] cars) {
        this.race = new Race(cars);
    }

    public void start() {
        race.start();
    }

    public List<Car> getWinners() {
        return race.getWinners();
    }

    public List<Car> getCars() {
        return race.getCars();
    }
}
