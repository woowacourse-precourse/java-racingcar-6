package racingcar.domain;

import racingcar.view.InputView;

public class CarGameManager {

    public Cars carNamesSet() {
        return Cars.createCars(InputView.startInputView());
    }
}
