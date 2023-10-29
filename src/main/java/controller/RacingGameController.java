package controller;

import java.util.List;
import validator.CarNameValidator;
import view.InputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final CarNameValidator carNameValidator = new CarNameValidator();

    public void play() {
        List<String> carNameList = inputView.getCarNames();
        validateCarNames(carNameList);


    }

    public void validateCarNames(List<String> carNameList) {
        carNameValidator.validateCarNameLength(carNameList);
        carNameValidator.validateCarNameDuplicate(carNameList);
    }

}
