package racingcar.controller;

import racingcar.utils.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    InputValidator inputValidator = new InputValidator();
    InputView inputView = new InputView();

    public void proceedRacing() {
        List<String> validCarNames;
        validCarNames = getValidCarNames();
    }

    private List<String> getValidCarNames() {
        String carsNameInput = inputView.askCarsName();
        String preprossedInputNames = inputValidator.preprocessInputString(carsNameInput);
        return inputValidator.validateCarsNameInput(preprossedInputNames);
    }
}
