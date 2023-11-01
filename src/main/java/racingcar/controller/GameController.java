package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;


    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        Race race = new Race(
                inputView.readCarNames(),
                inputView.readRoundCount()
        );
        race.play();

        outputView.printExecutionResultMessage(race.getExecutionResults());
        outputView.printWinnerResultMessage(race);
    }
}
