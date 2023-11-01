package racingcar.controller;

import static racingcar.view.ConsoleInput.inputCarNames;
import static racingcar.view.ConsoleInput.inputPlayNumber;
import static racingcar.view.ConsoleOutput.informInputCarNames;
import static racingcar.view.ConsoleOutput.informInputPlayNumber;
import static racingcar.view.ConsoleOutput.informPlayResult;
import static racingcar.view.ConsoleOutput.printFinalWinner;
import static racingcar.view.ConsoleOutput.printNewLine;
import static racingcar.view.ConsoleOutput.printProgressState;

import java.util.List;
import racingcar.domain.CarManager;
import racingcar.domain.FinalResult;
import racingcar.domain.ProgressState;


public class RacingGame {

    public static void run() {
        informInputCarNames();
        List<String> carNames = inputCarNames();
        CarManager.makeCarList(carNames);

        informInputPlayNumber();
        int playNumber = inputPlayNumber();
        printNewLine();

        informPlayResult();
        play(playNumber);

        FinalResult finalResult = CarManager.getFinalWinner();
        printFinalWinner(finalResult);
    }

    private static void play(int playNumber) {
        for (int i : new int[playNumber]) {
            CarManager.proceed();
            ProgressState progressState = CarManager.getState();
            printProgressState(progressState);
            printNewLine();
        }
    }
}
