package racingcar.controller;

import racingcar.model.CarNameValidator;
import racingcar.model.RoundNumValidator;
import racingcar.view.InputView;

import java.util.ArrayList;

public class InputController {
    public ArrayList<String> carValidate(){
        CarNameValidator carNameValidator = new CarNameValidator(InputView.carInput());
        return carNameValidator.carNameList;
    }

    public int roundValidate(){
        RoundNumValidator roundNumValidator = new RoundNumValidator(InputView.roundInput());
        return Integer.parseInt(roundNumValidator.roundInput);
    }
}
