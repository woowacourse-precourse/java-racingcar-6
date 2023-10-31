package racingcar.controller;

import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private RacingModel racingModel;

    private int roundCount;

    public void start() {
        setUp();
        play();
        showWinner();
    }

    public void setUp() {
        InputController inputController = new InputController();
        racingModel = new RacingModel(inputController.setCarNames(InputView.inputCarNames()));
        roundCount = inputController.setRoundCount(InputView.inputRoundCount());
    }

    public void play() {
        OutputView.printRoundResultMessage();
        for(int i = 1; i <= roundCount; i++) {
            racingModel.playRound().forEach(OutputView::printRoundResult);
            System.out.println();
        }

    }

    public void showWinner() {
        OutputView.printWinner(racingModel.getWinner());
    }


}
