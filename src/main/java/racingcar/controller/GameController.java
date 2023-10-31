package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.Util;
import racingcar.model.Car;
import racingcar.model.Judge;
import racingcar.model.Round;
import racingcar.view.JudgeView;
import racingcar.view.RoundView;
import racingcar.view.SystemView;

public class GameController {

    private List<Car> cars;
    private int roundNumber;

    public GameController() {
        set();
        game();
        judge();
    }

    public void set() {

        SystemView.promptForCarNames();
        List<String> carNames = CarController.getCarNamesFromUser(Util.readLine());

        SystemView.promptForRoundNumber();
        roundNumber = RoundController.setRound();

        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.nameOf(carName));
        }
    }

    public void game() {

        SystemView.displayGameResults();
        Round round = Round.carsOf(cars);

        for (int i = 0; i < roundNumber; i++) {
            round.moveAllCarsOneRound();
            RoundView.printRoundResults(cars);

        }
    }

    public void judge() {

        List<Car> winners = Judge.determineWinners(cars);
        JudgeView.printWinners(winners);
    }

}

