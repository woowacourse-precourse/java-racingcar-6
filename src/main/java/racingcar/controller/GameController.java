package racingcar.controller;

import racingcar.model.randomnumber.RandomNumber;
import racingcar.view.input.InputView;
import racingcar.view.output.Outputview;

public class GameController {

    private final InputView inputView;
    private final Outputview outputView;
    private final RandomNumber randomNumber;

    public GameController(final InputView inputView, final Outputview outputView, final RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }

    public void play() {
        outputView.askCarNames();
    }
}
