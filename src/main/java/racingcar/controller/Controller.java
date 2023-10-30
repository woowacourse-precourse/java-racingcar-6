package racingcar.controller;

import racingcar.domain.Announcer;
import racingcar.domain.Random;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final static Random random = new Random();
    private final static Referee referee = new Referee();
    private final static Announcer announcer = new Announcer();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public void start() {
    }
}
