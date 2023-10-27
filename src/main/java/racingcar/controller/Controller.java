package racingcar.controller;

import java.util.List;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Racing racing = new Racing();

    public void racingGame() {
        List<String> carNames = inputView.askName();
        int forwardCount = 0;
        int count = inputView.askGameCount();
//
    }
}