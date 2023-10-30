package racingcar.configure;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfigure {
    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        return new InputView();
    }
}
