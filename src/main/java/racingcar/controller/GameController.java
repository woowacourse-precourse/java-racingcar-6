package racingcar.controller;

import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class GameController {

    public GameController() {}

    public void startGame() {
    }

    private List<String> getInputNames() {
        String inputNames = InputView.inputCarNames();

        return Arrays.stream(inputNames.split(","))
                .toList();
    }
}
