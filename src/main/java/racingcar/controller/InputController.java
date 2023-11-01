package racingcar.controller;

import java.util.List;
import racingcar.utils.Util;
import racingcar.utils.Validator;
import racingcar.view.InputView;

public class InputController {

    private final InputView inputView = new InputView();

    List<String> getCarNames() {
        String input = inputView.getCarNames();
        return inputToStringList(input);
    }

    int getTrialNumber() {
        String input = inputView.getTrialNumber();
        Validator.validateIsInteger(input);
        return Integer.parseInt(input);
    }

    private List<String> inputToStringList(String input) {
        String removeSpaceResult = Util.removeSpace(input);
        String[] splitByCommaResult = Util.splitByComma(removeSpaceResult);
        return Util.arrayToList(splitByCommaResult);
    }
}