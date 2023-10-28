package racingcar.controller;

import racingcar.function.CheckName;
import racingcar.value.Value;
import racingcar.view.InputView;
import racingcar.function.CheckNumber;
import racingcar.function.GoStopRule;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    private final Value values;
    private final GoStopRule goStopRule;


    public Controller() {
        this.values = new Value();
        this.goStopRule = new GoStopRule();
    }

    public void run() {
        carName();
        raceAttempts();
        gameStart();
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

    private void gameStart() {
        int roundOfGame = values.getNumberOfAttempts();

        List<Integer> carPositions = new ArrayList<>();
        for (int i = 0; i < values.getCarNames().size(); i++) {
            carPositions.add(0);
        }

        for (int round = 0; round < roundOfGame; round++) {
            playRound(carPositions);
        }
    }
    private void playRound(List<Integer> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            if (goStopRule.shouldGo()) {
                carPositions.set(i, carPositions.get(i) + 1);
            }
        }
    }
}