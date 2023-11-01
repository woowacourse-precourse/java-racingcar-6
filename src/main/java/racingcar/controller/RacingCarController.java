package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.formula.Formula;
import racingcar.domain.formula.MoveFormula;
import racingcar.domain.game.RaceGame;
import racingcar.domain.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.RaceGameInput;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        RaceGameInput raceGameInput = inputView.readRaceGameInput();
        List<Car> cars = CarFactory.createCars(raceGameInput.carNames());
        Formula moveFormula = new MoveFormula(new RandomNumberGenerator());

        RaceGame raceGame = new RaceGame(moveFormula, cars, raceGameInput.round());
        outputView.printStartRaceGame();
        raceGame.race(outputView::printRaceGameResults);
        outputView.printFinalHeadOfRace(raceGame.currentHeadOfRace());
    }
}
