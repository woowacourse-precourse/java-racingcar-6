package racingcar.controller;

import racingcar.function.CheckName;
import racingcar.value.Value;
import racingcar.view.InputView;
import racingcar.function.CheckNumber;
import racingcar.function.GoStopRule;
import racingcar.view.OutputView;

import java.util.List;


public class Controller {
    private final Value values;
    private final GoStopRule goStopRule;
    private final OutputView outputView;

    public Controller() {
        this.values = new Value();
        this.goStopRule = new GoStopRule();
        this.outputView = new OutputView();
    }

    public void run() {
        carName();
        raceAttempts();
        initGame();
        gameStart();
        gameEnd();
    }

    private void carName() {
        String inputNames = InputView.inputCarNames();
        CheckName.validate(inputNames);
        values.addCarNames(inputNames.split(","));
    }

    private void raceAttempts() {
        String input = InputView.inputNumberOfAttempts();
        int numberOfAttempts = CheckNumber.validate(input);
        values.setNumberOfAttempts(numberOfAttempts);
    }

    private void initGame() {
        int numberOfCars = values.getCarNames().size();
        values.initializeCarPositions(numberOfCars);
    }

    private void gameStart() {
        int roundOfGame = values.getNumberOfAttempts();
        for (int round = 0; round < roundOfGame; round++) {
            playRound();
            printRoundResult();
        }
    }

    private void playRound() {
        List<Integer> carPositions = values.getCarPositions();
        for (int i = 0; i < carPositions.size(); i++) {
            goStop(i);
        }
    }

    private void goStop(int carIndex) {
        if (goStopRule.shouldGo()) {
            int newPosition = values.getCarPositions().get(carIndex) + 1;
            values.updateCarPositions(carIndex, newPosition);
        }
    }

    private void printRoundResult() {
        outputView.printRoundResult(values.getCarNames(), values.getCarPositions());
    }

    private void gameEnd() {
        values.determineWinners();
        printWinner();
    }

    private void printWinner() {
        outputView.printWinners(values.getWinners());
    }
}