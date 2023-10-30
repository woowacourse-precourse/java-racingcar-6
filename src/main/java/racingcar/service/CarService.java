package racingcar.service;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarService {

    public List<String> getCarNames(){
        OutputView.inputCarNamesMessage();
        return InputView.readCarNames();
    }
}
