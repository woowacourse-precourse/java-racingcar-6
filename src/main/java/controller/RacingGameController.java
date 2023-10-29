package controller;

import java.util.List;
import validator.CarNameValidator;
import validator.TryCountValidator;
import view.InputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TryCountValidator tryCountValidator = new TryCountValidator();

    public void play() {
        List<String> carNameList = inputView.getCarNames();
        validateCarNames(carNameList);

        String tryCount = inputView.getTryCount();
        validateTryCount(tryCount);
        int tryCountNumber = Integer.parseInt(tryCount);

    }


    public void validateCarNames(List<String> carNameList) {
        carNameValidator.validateCarNameLength(carNameList);
        carNameValidator.validateCarNameDuplicate(carNameList);
    }

    public void validateTryCount(String tryCount) {
        tryCountValidator.validateTryCountNumber(tryCount);
        tryCountValidator.validateTryCountMin(tryCount);
    }

}
