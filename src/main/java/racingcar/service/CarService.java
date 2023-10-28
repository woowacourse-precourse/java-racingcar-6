package racingcar.service;

import racingcar.util.validator.InputValidator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class CarService {

    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();

    public void getCarNameAndTryCount() {
        getCarNameAndCheckValidation();
        getTryCountAndCheckValidation();
    }

    private void getCarNameAndCheckValidation() {
        List<String> carNameList = splitCarNames(inputView.getCarNames());
        inputValidator.checkCarNameInputValidation(carNameList);
    }

    private void getTryCountAndCheckValidation() {
        inputValidator.checkTryCountInputValidation(inputView.getTryCount());
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}
