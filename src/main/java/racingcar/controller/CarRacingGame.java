package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;

import java.util.List;

public class CarRacingGame {
    private List<Car> cars;
    private GameService gameService;

    public CarRacingGame() {
        this.gameService = new GameService();
    }

    public void gameStart() {
    }
}
