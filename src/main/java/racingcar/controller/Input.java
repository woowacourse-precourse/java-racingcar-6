package racingcar.controller;

import racingcar.util.CarNameValidator;
import racingcar.model.Cars;
import racingcar.util.TryCountValidator;
import racingcar.view.InputView;

public class Input {
    public static Cars setRacingCars(){
        CarNameValidator validation = new CarNameValidator(InputView.inputCarName());
        validation.validate();
        return new Cars(validation.NAMES);
    }
    public static int setTryCount(){
        TryCountValidator validation = new TryCountValidator(InputView.inputTryCount());
        validation.validate();
        return Integer.parseInt(validation.TRY_COUNT_STRING);
    }
}