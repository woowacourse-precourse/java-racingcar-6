package racingcar.controller;

import java.util.List;
import racingcar.util.Validation;
import racingcar.view.InputView;

public class RacingController {

    Validation validation = new Validation();
    InputView inputView = new InputView();

    public void startRacing() {
        List<String> carNames = getCarNameList();

    }

    private List<String> getCarNameList() {
        String askCarName = inputView.insertCarName();
        return null;
    }

}
