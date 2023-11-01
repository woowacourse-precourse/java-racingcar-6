package racingcar.controller;


import racingcar.model.Car;
import racingcar.model.GameModel;
import racingcar.model.Race;

import java.util.List;


public class GameController {
    private final GameModel gameModel;

    public GameController() {
        this.gameModel = new GameModel();
    }

    public void play() {
        List<String> carNameList = gameModel.getCarName();

        List<Car> carList = carNameList.stream()
                .map(Car::new)
                .toList();

        int rounds = gameModel.getRounds();

        Race race = new Race(carList, rounds);
        race.raceStart();
        race.getRaceWinner();
    }
}