package racingcar.view;

import java.util.List;

public class RacingView {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public List<String> getCarNames() {
        outputView.printRaceStartingMessage();
        return inputView.getCarNames();
    }
}
