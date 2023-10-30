package racingcar.controller;

import racingcar.dto.request.CarNameRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameManagerController {
    private List<CarNameRequest> getCarNames() {
        OutputView.printCarNameInputQuestion();
        return InputView.requestCarNames();
    }
}
