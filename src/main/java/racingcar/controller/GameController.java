package racingcar.controller;

import java.util.List;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<String> carNameList = inputView.getCarName();
        int trialNum = inputView.getTrialNum();
        race = new Race(trialNum, carNameList);

    }

}
