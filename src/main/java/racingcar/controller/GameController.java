package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    public void playGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> racingCarNames = splitRacingCarNames(inputView.inputRacingCarNames());
    }

    static public List<String> splitRacingCarNames(String racingCarNames) {
        return Arrays.asList(racingCarNames.split(","));
    }
}
