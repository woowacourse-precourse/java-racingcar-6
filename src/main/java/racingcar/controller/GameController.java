package racingcar.controller;

import racingcar.view.input.InputView;
import racingcar.view.output.Outputview;

public class GameController {

    private final InputView inputView;
    private final Outputview outputView;

    public GameController(final InputView inputView, final Outputview outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {}
}
