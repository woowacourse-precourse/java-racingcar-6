package racingcar.configure;

import racingcar.domain.Manager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfigure {
    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        return new InputView();
    }

    public Manager manager() {
        return new Manager();
    }
}
