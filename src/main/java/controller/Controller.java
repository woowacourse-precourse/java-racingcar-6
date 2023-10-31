package controller;

import java.util.List;
import model.Car;
import model.Cars;
import model.Game;
import model.TrialNumber;
import model.Winners;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame(){
        Cars cars = getCars();
        TrialNumber trialNumber = getTrialNumber();
        Game game = new Game(cars,trialNumber);
        outputView.displayResultMessage();
        Winners winners = race(cars,trialNumber,game);
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
