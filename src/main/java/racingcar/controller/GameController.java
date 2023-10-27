package racingcar.controller;

import java.util.List;
import racingcar.util.CarNamesInputConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        initGame();
        // TODO
    }

    private void initGame() {
        List<String> carNames = inputCarNames();
    }

    private List<String> inputCarNames() {
        outputView.displayInputCarNames();
        String input = inputView.inputCarNames();
        return CarNamesInputConverter.convert(input);
    }
}
