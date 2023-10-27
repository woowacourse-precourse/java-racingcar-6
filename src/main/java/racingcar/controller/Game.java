package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.view.constants.Notice.ASK_MULTIPLE_CAR_NAMES;

public class Game {
    public static void start() {
        OutputView.printStaticMessage(ASK_MULTIPLE_CAR_NAMES);
        String input = InputView.playerInput();
        Cars cars = Cars.create(input);
    }
}
