package racingcar.controller;

import racingcar.RacingcarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;

public class RacingcarGameController {
    InputView inputView;
    OutputView outputView;
    RacingcarGame racingcarGame;

    public RacingcarGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingcarGame = new RacingcarGame();
    }

    public void start() {
        setCarsName();
        setTryCount();
        outputView.readOngoingResultMessage();
        do {
            outputView.readOngoingResult(ongoing());
        } while (racingcarGame.isContinue());
        outputView.readWinner(racingcarGame.getWinner());
    }

    private void setTryCount() {
        inputView.readInputTryCountMessage();
        racingcarGame.setTryCount(inputView.getTryCount());
    }

    private void setCarsName() {
        inputView.readInputCarNameMessage();
        racingcarGame.setCars(inputView.getCarsName());
    }

    private HashMap<String, Integer> ongoing() {
        return racingcarGame.race();
    }
}
