package racingcar.service;

import static racingcar.constant.RacingGameConstants.INITIAL_PLAY_NUMBER;
import static racingcar.domain.CarManager.getFinalWinner;
import static racingcar.domain.CarManager.makeCarList;
import static racingcar.view.ConsoleInput.inputCarNames;
import static racingcar.view.ConsoleInput.inputPlayNumber;
import static racingcar.view.ConsoleOutput.informInputCarNames;
import static racingcar.view.ConsoleOutput.informInputPlayNumber;
import static racingcar.view.ConsoleOutput.informPlayResult;
import static racingcar.view.ConsoleOutput.printFinalWinner;
import static racingcar.view.ConsoleOutput.printNewLine;
import static racingcar.view.ConsoleOutput.printProgressState;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.CarManager;
import racingcar.dto.FinalResult;
import racingcar.dto.ProgressState;

public class RacingGameService {
    private static int playNumber = INITIAL_PLAY_NUMBER;

    public static void proceedCarNameInputStage() {
        informInputCarNames();
        List<String> carNames = inputCarNames();
        makeCarList(carNames);
    }

    public static void proceedPlayNumberInputStage() {
        informInputPlayNumber();
        playNumber = inputPlayNumber();
        printNewLine();
    }

    public static void proceedPlayStage() {
        informPlayResult();
        play();
    }

    public static void proceedAwardStage() {
        FinalResult finalResult = getFinalWinner();
        printFinalWinner(finalResult);
    }

    private static void play() {
        for (int ignore : new int[playNumber]) {
            CarManager.proceed();
            ProgressState progressState = CarManager.getState();
            printProgressState(progressState);
            printNewLine();
        }
    }

    public static void end() {
        Console.close();
    }

}
