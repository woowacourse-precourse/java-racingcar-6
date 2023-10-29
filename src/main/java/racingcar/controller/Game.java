package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarCreator;
import racingcar.model.RaceManager;
import racingcar.view.View;

public class Game {

    public static void start() {
        String carNamesString = View.getInput();
        List<String> carNames = CarCreator.splitCarNamesString(carNamesString);
        CarCreator.validateCarNames(carNames);
        List<Car> cars = CarCreator.createCars(carNames);

        String numberOfMove = View.getInput();
        RaceManager.validateNumberOfMove(numberOfMove);

        RaceManager.startRace(cars);

        List<String> winnerList = RaceManager.decideWinner(cars);
    }
}
