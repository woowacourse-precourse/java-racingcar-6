package controller;

import model.AttemptNumberConverter;
import model.Cars;
import model.Referee;
import view.InputView;
import view.ProgressView;
import view.ResultView;

import java.util.List;

public class RacingGameController {
    private final CarController carController = new CarController();
    private Cars cars;
    private int attemptNumber;
    private List<String> winner;

    public void start() {
        receiveCarsName();
        receiveAttemptNumber();
        repeatMove();
        printWinner();
    }

    private void receiveCarsName() {
        cars = new Cars(carController.makeCars());
    }

    private void receiveAttemptNumber() {
        String attemptNumberAsString = InputView.inputAttemptNumber();
        attemptNumber = AttemptNumberConverter.convertStringToInteger(attemptNumberAsString);
    }

    private void repeatMove() {
        ProgressView.printProgressResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            cars.moveAll();
            ProgressView.printProgress(cars);
        }
    }

    private void printWinner() {
        findWinner();
        ResultView.printResult(winner);
    }

    private void findWinner() {
        Referee referee = new Referee();
        referee.competeCars(cars);
        winner = referee.getWinner();
    }
}
