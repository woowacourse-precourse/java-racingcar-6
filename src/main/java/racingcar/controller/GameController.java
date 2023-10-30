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
        validateRacingCarNames(racingCarNames);
    }

    static public List<String> splitRacingCarNames(String racingCarNames) {
        return Arrays.asList(racingCarNames.split(","));
    }

    static public void validateRacingCarNames(final List<String> racingCarNames) {
        if (racingCarNames.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (String racingCarName : racingCarNames) {
            if (racingCarName.isEmpty()) {
                throw new IllegalArgumentException();
            } else if (racingCarName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
