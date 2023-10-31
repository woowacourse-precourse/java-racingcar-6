package racingcar.controller;

import racingcar.model.move.RandomMove;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomMove randomMove;

    public GameController(InputView inputView, OutputView outputView, RandomMove randomMove) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomMove = randomMove;
    }

}
