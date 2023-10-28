package racingcar.controller;

import racingcar.service.CarService;
import racingcar.util.validator.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingGameController {
    InputView inputView = new InputView();
    CarService carService = new CarService();
    InputValidator inputValidator = new InputValidator();

    public void gameStart() {
        getCarNameAndCheckValidation();
        getTryCountAndCheckValidation();
    }

    private void getCarNameAndCheckValidation() {
        List<String> carNameList = carService.splitCarNames(inputView.getCarNames());
        inputValidator.checkCarNameInputValidation(carNameList);
    }

    private void getTryCountAndCheckValidation() {
        inputValidator.checkTryCountInputValidation(inputView.getTryCount());
    }
}
