package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private OutputView outputView;
    private InputView inputView;
    private Race race;

    public MainController() {
        outputView = new OutputView();
        inputView = new InputView();
        race = new Race();
    }
}
