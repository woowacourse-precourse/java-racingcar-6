package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.TrialNumber;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        Cars cars = getCars();
        TrialNumber trialNumber = getTrialNumber();
        Game game = new Game(cars, trialNumber);
        outputView.displayResultMessage();
        Winners winners = race(cars, trialNumber, game);
        outputView.displayWinners(winners);
    }

    private Cars getCars() {
        return new Cars(inputView.inputCarNames());
    }

    private TrialNumber getTrialNumber() {
        return new TrialNumber(inputView.inputTrialNumber());
    }

    private Winners race(Cars cars, TrialNumber trialNumber, Game game) {
        while (!game.isGameEnd(trialNumber)) {
            game.playGame(cars);
            outputView.displayRoundStatus(cars);
            game.nextRound(trialNumber);
        }
        Winners winners = new Winners(cars);
        return winners;
    }


}
