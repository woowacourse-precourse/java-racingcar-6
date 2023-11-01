package racingcar.controller;

import racingcar.function.NameChecker;
import racingcar.value.Value;
import racingcar.view.InputView;
import racingcar.function.NumberChecker;
import racingcar.function.GoStopRule;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private String inputNames;
    private String inputNumber;
    private int numberOfAttempts;
    private final Value values;
    private final GoStopRule goStopRule;
    private final OutputView outputView;

    public Controller() {
        this.values = new Value();
        this.goStopRule = new GoStopRule();
        this.outputView = new OutputView();
    }

    public void run() {
        inputCarName();
        validateCarName();
        saveCarName();
        inputRaceAttempts();
        validateAttemptNumber();
        saveAttemptNumber();
        initGame();
        gameStart();
        gameEnd();
        printWinner();
    }

    private void inputCarName() {
        this.inputNames = InputView.inputCarNames();
    }

    private void validateCarName() {
        NameChecker.validate(this.inputNames);
    }

    private void saveCarName() {
        String[] names = this.inputNames.split(",");
        values.addCarNames(names);
    }

    private void inputRaceAttempts() {
        this.inputNumber = InputView.inputNumberOfAttempts();
    }

    private void validateAttemptNumber() {
        this.numberOfAttempts = NumberChecker.validate(this.inputNumber);
    }

    private void saveAttemptNumber() {
        values.setNumberOfAttempts(this.numberOfAttempts);
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
    }

    private void printWinner() {
        outputView.printWinners(values.getWinners());
    }
}