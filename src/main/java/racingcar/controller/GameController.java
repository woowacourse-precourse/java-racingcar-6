package racingcar.controller;

import racingcar.Utils;
import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.OutputView;

public class GameController {
    private Cars cars;
    private Attempt attempt;
    private Game game;

    public GameController() {
        cars = new Cars();
        attempt = new Attempt();
    }

    public void startRacing() {
        initialize();
        playRacing();
    }

    public void initialize() {
        cars.createCars();
        attempt.saveAttemptNumber();
        Utils.printLineChanging();

        game = new Game(cars.getCars(), attempt.getAttemptNumber());
    }

    public void playRacing() {
        OutputView.printResultMessage();
        game.start();
    }
}
