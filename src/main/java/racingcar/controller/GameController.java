package racingcar.controller;

import racingcar.view.input.InputView;
import racingcar.view.output.Outputview;

public class GameController {

    private final InputView inputView;
    private final Outputview outputview;

    public GameController(final InputView inputView, final Outputview outputview) {
        this.inputView = inputView;
        this.outputview = outputview;
    }

    public void play() {}
}
