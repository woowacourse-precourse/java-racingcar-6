package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RacingGame;

public class RacingGameService {

    private final RacingCars cars;
    private final RacingGame game;

    public RacingGameService() {
        this.cars = new RacingCars();
        this.game = new RacingGame();
    }

    public List<Car> getRacingCars(String carName) {
        return cars.createRacingCars(carName);
    }

    public List<Car> move(List<Car> carList) {
        cars.moveCars(carList);
        return carList;
    }

    public int getTryCount(String tryCount) {
        return game.getTryCount(tryCount);
    }

    public List<String> getWinners(List<Car> carList) {
        return game.getWinners(carList);
    }
}
