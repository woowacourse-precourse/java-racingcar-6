package racingcar.domain;

import java.util.List;
import racingcar.utils.WinnerFinder;

public class Game {

    private List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        return WinnerFinder.findWinners(cars);
    }
}
