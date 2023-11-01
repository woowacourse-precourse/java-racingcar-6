package racingcar.controller;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import java.util.List;

import static racingcar.util.GameInputReader.*;
import static racingcar.util.InputConvertUtils.carNamesToNameList;

public class RacingCarGame {

    public void play() {
        InputView.printDemandCarNames();
        Cars cars = new Cars(readCarNames());

        InputView.printDemandAttemptCount();
        Attempt attempt = new Attempt(readInt());
    }

    private static List<String> readCarNames() {
        return carNamesToNameList(readExistLine());
    }
}
