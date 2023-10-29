package racingcar;

import racingcar.domain.Controller;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.startInputMessage();
        Controller.validateCarNames();
    }
}
