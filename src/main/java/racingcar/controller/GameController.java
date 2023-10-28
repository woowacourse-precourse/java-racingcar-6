package racingcar.controller;

import racingcar.model.Name;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final Name name = new Name();
    public void start() {
        List<String> player = Arrays.asList(inputView.name().split(","));
        name.isValid(player);
    }
}
