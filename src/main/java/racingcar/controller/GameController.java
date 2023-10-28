package racingcar.controller;

import racingcar.utils.Validator;
import racingcar.view.InputView;

import java.util.List;

public class GameController {

    public static List<String> getCarNames() {
        String input = InputView.readFromUser();
        return Validator.validateCarNames(input);
    }
}
