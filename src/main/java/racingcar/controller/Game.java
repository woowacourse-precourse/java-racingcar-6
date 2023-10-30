package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final OutputView outputView;
    private final InputView inputView;

    public Game(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printGameStart();
        List<String> inputString = inputView.inputPlayerList();
    }
}
