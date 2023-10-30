package racingcar.controller;

import racingcar.util.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Utils utils;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.utils = new Utils();
    }

}
