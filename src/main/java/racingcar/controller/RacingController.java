package racingcar.controller;

import racingcar.domain.CarsDto;
import racingcar.util.CarNamesValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.beforeInputCarNames();
        String inputtedCarNames = inputView.inputCarNames();
        List<String> validatedCarNames = CarNamesValidator.getValidatedCarNamesList(inputtedCarNames);

        CarsDto carsDto = new CarsDto(validatedCarNames);
    }
}
